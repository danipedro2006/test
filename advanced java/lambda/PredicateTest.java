package main.advanced.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


// boolean test(T t);
public class PredicateTest {

    List<Product> products;

    static Predicate<Integer> hasWarrantyMoreThan2Years = warranty -> warranty > 2;
    static Predicate<Integer> hasWarrantyLessThan5Years = warranty -> warranty < 5;
    static Predicate<Float> isCheaperThan100 = price -> price < 100;

    static Predicate<Product> isProductCheaperThan100 =
            product -> product.getPrice() < 100;

    static Predicate<Product> isProductMoreExpensiveThan15 =
            product -> product.getPrice() > 15;

    static Predicate<Product> hasProductWarrantyMoreThan2Years =
            p -> p.getWarranty() > 2;

    static Predicate<Product> hasProductWarrantyLessThan5Years =
            product -> product.getWarranty() < 5;


    public static void main(String[] args) {

        Product vcr = new Product("video recorder", 3, 20.55f);
        Product cdPlayer = new Product("cd player", 2, 50.55f);
        Product photoCamera = new Product("photo camera", 3, 129.55f);

        System.out.println(
                "Product hasWarrantyMoreThan2Years: "
                        + hasWarrantyMoreThan2Years.test(vcr.getWarranty()));

        printPriceInfo(vcr, isCheaperThan100);


        System.out.println(
                "Product isCheaperThan100 or hasWarrantyMoreThan2Years: "
                        + (isCheaperThan100.test(vcr.getPrice())
                        || hasWarrantyMoreThan2Years.test(vcr.getWarranty())));


        System.out.println("Warranty between 2 and 5 years: "
                + hasWarantyMoreThan2AndLessThan5()
                //.negate()
                .test(vcr.getWarranty()));


    }

    @BeforeEach
    public void beforeEach(){

        Product vcr = new Product("video recorder", 3, 20.55f);
        Product cdPlayer = new Product("cd player", 2, 50.55f);
        Product photoCamera = new Product("photo camera", 3, 12);
        Product refrigerator = new Product("refrigerator", 1, 250.55f);
        Product tv = new Product("tv", 5, 339f);

        products = List.of(vcr, cdPlayer, photoCamera, tv, refrigerator);
    }



    @Test
    public void test() {

        Stream<Product> productsStream = products.stream();

        final Function<Product, Float> productToPrice = product -> product.getPrice();

        final Function<Float, Boolean> priceLessThan100 = price -> price < 100;
        System.out.println(priceLessThan100.apply(150f));

        List<Float> pricesCheaperThan100 = productsStream
                .map(productToPrice)
                .filter(isCheaperThan100.negate())
                .collect(toList());

        System.out.println(pricesCheaperThan100);

        products.forEach(System.out::println);

        List<String> productsNamesCheaperThan100 = products.stream()
                .filter(isProductCheaperThan100)
                .map(product -> product.getName())
                // .map(Product::getName)
                .collect(toList());

        System.out.println(productsNamesCheaperThan100);

    }


    @Test
    public void test_filters() {

        //products.forEach(System.out::println);


/*      Stream<Product> productsStream = products.stream();

        System.out.println("Filter products by price < 100");
        Stream<Product> filteredStream = productsStream.filter(isProductCheaperThan100);
        List<Product> filteredList = filteredStream.collect(toList());
        filteredList.forEach(System.out::println);*/

        // one line
        System.out.println("Lambda");
        filterListUsingStreams(products).forEach(System.out::println);


        System.out.println("Classic");
        filterProductsWithWarrantyMoreThan2AndLessThan5(products)
                .forEach(System.out::println);


    }

    public List<Product> filterListUsingStreams(List<Product> products) {

        return products.stream()
                .filter(product -> product.getWarranty() > 2)
                .filter(hasProductWarrantyLessThan5Years)
                .filter(isProductMoreExpensiveThan15)
                .collect(toList());
    }

    public List<Product> filterProductsWithWarrantyMoreThan2AndLessThan5(List<Product> products) {
        // classic itteration
        AbstractList<Product> filteredClassicList = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {

            final Product currentProduct = products.get(i);

            if (currentProduct.getWarranty() > 2
                    && currentProduct.getWarranty() < 5
                    && isProductMoreExpensiveThan15.test(currentProduct)) {

                filteredClassicList.add(currentProduct);
            }
        }
        return filteredClassicList;
    }


    public static Predicate<Integer> hasWarantyMoreThan2AndLessThan5() {

        return hasWarrantyLessThan5Years.and(hasWarrantyMoreThan2Years);
    }

    public static void printPriceInfo(
            Product vcr,
            Predicate<Float> isCheaperThan100) {

        System.out.println(
                "Product isCheaperThan100: "
                        + isCheaperThan100.test(vcr.getPrice()));
    }

}
