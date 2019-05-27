package main.advanced.bookStore;

import java.util.Map;

public class BookStoreStatus {

    private int booksQuantity;
    private float totalPrice;

    private Map<Book, Integer> eachBookQuantityMap;

    private Map<BookGenre, Integer> totalQuantityByGenreMap;
    private Map<BookGenre, Float> totalPriceByGenreMap;

    public BookStoreStatus(BookStore bookStore) {

        this.booksQuantity = bookStore.getTotalBooksQuantity();
        this.totalPrice = bookStore.getTotalPrice();

        this.eachBookQuantityMap = bookStore.getBookQuantityMap();
        this.totalQuantityByGenreMap = bookStore.getQuantityByGenreMap();
        this.totalPriceByGenreMap = bookStore.getPriceByGenreMap();
    }
}
