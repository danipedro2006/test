package main.advanced.bookStore;

import org.junit.jupiter.api.Assertions;
import main.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BookStore {

/*    - a map of books with unique id (a randomBookId string of 4 digits).
            - a map of book quantities (key=bookId, value=quantity)

    Create an empty book store.*/

    private Map<String, Book> bookMap;
    private Map<String, Integer> quantityMap;


    public BookStore(Map<String, Book> bookMap,
                     Map<String, Integer> quantityMap) {

        this.bookMap = bookMap;
        this.quantityMap = quantityMap;
    }

    public BookStore() {

        this(
                new HashMap<String, Book>(),
                new HashMap<String, Integer>()
        );

    }


    final Function<String, BookInfo> keyToBookInfo = key -> new BookInfo(
            bookMap.get(key),
            quantityMap.get(key));


    public static BookInfo bookStringToBookInfo(String bookString) {

        String[] bookStringTokens = bookString.split("\\s*\\|\\s*");


        Assertions.assertEquals(6, bookStringTokens.length);

        return new BookInfo(

                new Book(
                        // book name
                        bookStringTokens[0],

                        // author
                        bookStringTokens[1],

                        // year
                        Integer.valueOf(bookStringTokens[2]),

                        // genre
                        BookGenre.valueOf(bookStringTokens[3].toUpperCase()),

                        // price
                        Float.valueOf(
                                bookStringTokens[4].replaceAll(
                                        "\\s*\\$\\s*",
                                        ""))
                ),
                Integer.valueOf(bookStringTokens[5])
        );
    }


    public boolean isBookInStore(Book book) {
        // wrong - compares objects
        return bookMap.values().contains(book);
        //return true;

    }


    public int getQuantity(Book book) {

        int quantity = 0;

        if (isBookInStore(book)) {
            String bookId = getBookId(book);
            quantity = quantityMap.get(bookId);
        }

        return quantity;
    }

    public String getBookId(Book currentBook) {

        List<String> books = bookMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(currentBook))
                .map(entry -> entry.getKey())
                .collect(toList());

        if (books.isEmpty()) {
            return "0000";
        }

        return books.get(0);

    }


    public void addBook(Book book, int quantity) {

        if (isBookInStore(book)) {

            String bookId = getBookId(book);

            int newQuantity = getQuantity(book) + quantity;

            quantityMap.put(bookId, newQuantity);

        } else {
            // book is not in store

            String bookId = generateBookId();

            bookMap.put(bookId, book);

            quantityMap.put(bookId, quantity);
        }

    }


    public void addBook(Path filepath) throws IOException {

        List<String> bookLines = FileUtils.fileLinesToList(filepath);

        //"The Hunger Games | Suzanne Collins | 2008 | FICTION | 11.25 $ | 20" -> BookInfo(...)
        List<BookInfo> bookInfoList = bookLines.stream()
                .filter(bookLineIsNotCommented)
                .filter(bookLineIsNotEmpty)
                .map(bookLine -> bookStringToBookInfo(bookLine))
                .collect(toList());

        bookInfoList.forEach(bookInfo -> addBook(
                bookInfo.getBook(),
                bookInfo.getQuantity()));

        //TODO unit test
    }

    public Predicate<String> bookLineIsNotCommented = bookLine ->
            false == bookLine.startsWith("//");

    public Predicate<String> bookLineIsNotEmpty = bookLine ->
            false == bookLine.isEmpty();


    public static String generateBookId() {
        return "" + (int) (Math.random() * 10000);
    }


    public String generateUniqId() throws Exception {

        final int totalRetries = 1000;

        String id = "";

        for (int i = 0; i < 1000; i++) {

            id = BookStore.generateBookId();

            if (bookMap.keySet().contains(id)) {
                break;
            }
        }


        if (id.isEmpty()) {
            throw new Exception("Cannot generate ID for new book.");
        }

        return id;
    }


    public String toString() {

        return bookMap.keySet().stream()
                .map(keyToBookInfoString)
                .collect(Collectors.joining("\n"));
    }

    public Function<String, String> keyToBookInfoString = key ->

            String.format("%s %s | quantity: %d",
                    key,
                    bookMap.get(key),
                    quantityMap.get(key));

    // #4 Searches
    public List<BookInfo> searchBookByName(String bookName) {

        // TODO HOMEWORK
        // extract lambdas to variables with relevant names
        return bookMap.keySet().stream()

                .filter(key -> bookMap.get(key).getName().equals(bookName))
                // stream of keys (String)

                .map(key -> bookMap.get(key))
                // stream of values (Book)

                .map(book -> new BookInfo(book, getQuantity(book)))
                // stream of BookInfo

                .collect(toList());
    }

    public List<BookInfo> searchBookByAuthor(String bookAuthor) {

        final Function<Book, BookInfo> bookToBookInfo = book ->
                new BookInfo(book, getQuantity(book));

        final Predicate<String> bookHasSpecifiedAuthor = key ->
                bookMap.get(key).getAuthor().equals(bookAuthor);

        final Function<String, Book> keyToBook = key -> bookMap.get(key);

        return bookMap.keySet().stream()

                .filter(bookHasSpecifiedAuthor)
                // stream of keys (String)

                .map(keyToBook)
                // stream of values (Book)

                .map(bookToBookInfo)
                // stream of BookInfo

                .collect(toList());
    }

    public List<BookInfo> searchBookByGenre(BookGenre bookGenre) {
        //TODO - HOMEWORK + UNITTEST
        return new ArrayList<>();
    }

    public List<BookInfo> searchBookByNameAndAuthor(
            String bookName,
            String bookAuthor) {

        final Predicate<String> bookHasSpecifiedName = key ->
                bookMap.get(key).getName().equals(bookName);

        final Predicate<String> bookHasSpecifiedAuthor = key ->
                bookMap.get(key).getAuthor().equals(bookAuthor);


        return bookMap.keySet().stream()

                .filter(bookHasSpecifiedName.and(bookHasSpecifiedAuthor))

                .map(keyToBookInfo)

                .collect(toList());
    }

    public List<BookInfo> searchBookByCheaperPrice(float topPrice) {

        final Predicate<String> priceCheaperThanTopPrice = key ->
                bookMap.get(key).getPrice() < topPrice;

        return bookMap.keySet().stream()

                .filter(priceCheaperThanTopPrice)

                .map(keyToBookInfo)

                .collect(toList());

    }

    public List<Book> getCheapestBooks() {

        return bookMap.values().stream()
                .filter(book -> book.getPrice() == getMinPrice())
                .collect(toList());
    }

    private float getMinPrice() {

        float minPrice = Float.MAX_VALUE;
        Collection<Book> books = bookMap.values();

        for (Book currentBook : books) {

            final float currentBookPrice = currentBook.getPrice();

            if (minPrice > currentBookPrice) {
                minPrice = currentBookPrice;

            }
        }

        return minPrice;
    }


    public int getMinQuantity() {

        IntStream quantitiesIntStream = quantityMap.values()
                .stream()
                // stream of Integers
                .mapToInt(i -> i);
        /*
            stream().mapToObj: IntStream ---> Stream<Integer>
            int ---> Integer

            stream().mapToInt: Stream<Integer> ---> IntStream
            Integer ---> int

            Use identity lambda for both mappings: i -> i

         */
                // stream of int (primitives)

        return quantitiesIntStream.min().orElse(0);
    }

    private boolean isStoreEmpty() {

        return quantityMap.size() == 0
                && bookMap.size() == 0;
    }

    public int getTotalBooksQuantity(){

        return quantityMap.values().stream()
                .mapToInt(i->i)
                .sum();
    }


    public float getTotalPrice(){

        final Function<String, Float> keyToTotalPricePerBook = key ->
                bookMap.get(key).getPrice() * quantityMap.get(key);

        double totalPrice = bookMap.keySet().stream()
                // key ---> bookPrice * kookQuantity
                .map(keyToTotalPricePerBook)
                .mapToDouble(i -> i)
                .sum();

        // remove decimals from floating point nr (keep 2 decimals)
        String twoDecimalsString = String.format("%.2f", totalPrice);
        return Float.valueOf(twoDecimalsString);
    }


    public Map<Book, Integer> getBookQuantityMap() {
        // TODO implement
        return Collections.emptyMap();
    }


    public Map<BookGenre, Integer> getQuantityByGenreMap() {
        // TODO implement
        return Collections.emptyMap();
    }

    public Map<BookGenre, Float> getPriceByGenreMap() {
        // TODO implement
        return Collections.emptyMap();
    }
}
