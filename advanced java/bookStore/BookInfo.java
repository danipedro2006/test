package main.advanced.bookStore;

public class BookInfo {

    Book book;
    Integer quantity;

    public BookInfo(Book book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object otherBookInfoObj) {

        final BookInfo otherBookInfo = (BookInfo) otherBookInfoObj;

        return this.book.equals(otherBookInfo.getBook())

                && (this.quantity == otherBookInfo.getQuantity());
    }

    @Override
    public String toString() {

        return book.toString() + " | " + quantity;
    }
}
