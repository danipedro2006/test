package main.advanced.optional;

import main.advanced.lambda.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest {


    private List<Product> products;

    @BeforeEach
    public void before() {

        Product vcr = new Product("video recorder", 3, 20.55f);
        Product cdPlayer = new Product("cd player", 2, 50.55f);
        Product photoCamera = new Product("photo camera", 3, 12);
        Product refrigerator = new Product("refrigerator", 1, 250.55f);
        Product tv = new Product("tv", 5, 339f);

        products = List.of(vcr, cdPlayer, photoCamera, tv, refrigerator);

    }


    @Test
    public void test_optional() {

        System.out.println("Null Product (wrapped in empty optional, avoid java.lang.NullPointerException):");
        Optional<Product> optionalVcr = Optional.ofNullable(
                getVcr(false));

        printOptionalIfElse(optionalVcr);
        printOptionalNameOrElse(optionalVcr);
        printOptionalNameStream(optionalVcr);


        System.out.println("\nNon null Product:");
        optionalVcr = Optional.ofNullable(
                getVcr(true));

        printOptionalIfElse(optionalVcr);
        printOptionalNameOrElse(optionalVcr);
        printOptionalNameStream(optionalVcr);

    }

    public void printOptionalNameOrElse(Optional<Product> optionalProduct) {

        System.out.println(optionalProduct
                .orElse(new Product("No product", 0, 0))
                .getName());
    }

    public void printOptionalNameStream(Optional<Product> optionalProduct) {

        System.out.println(
                optionalProduct.stream()
                        .map(product -> "" + product.getPrice())
                        .collect(Collectors.joining()));
    }


    public void printOptionalIfElse(Optional<Product> optionalProduct) {
        // classic version
        if (optionalProduct.isPresent()) {
            System.out.println(optionalProduct.get());
        } else {
            System.out.println("No product");
        }
    }

    public Product getVcr(boolean isProductNeeeded) {

        Product product = null;

        if (isProductNeeeded) {
            product = new Product("video recorder", 3, 20.55f);
        }

        return product;
    }



    @Test
    public void test_stream_joining(){
        List<String> sentenceWords = List.of("This", "is", "a", "beautiful", "car");
        System.out.println(sentenceWords);

        String sentence = sentenceWords.stream().collect(Collectors.joining(" "));
        System.out.println(sentence);
    }
}
