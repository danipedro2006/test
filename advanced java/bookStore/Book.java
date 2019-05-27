package main.advanced.bookStore;

public class Book {

    private String name;
    private String author;
    private int year;
    private BookGenre genre;
    private float price;


    @Override
    public boolean equals(Object otherBookObject) {

        Book otherBook = (Book)otherBookObject;

        boolean isEqual = this.name.equals(otherBook.getName().trim())
                && this.author.equals(otherBook.getAuthor().trim())
                && this.genre.equals(otherBook.getGenre())
                && (this.year == (otherBook.getYear()))
                && (this.price == otherBook.getPrice());

        return isEqual;
    }


    @Override
    public String toString() {

        return String.format(" | %25s | %25s | %d | %10s | %.2f",
                name,
                author,
                year,
                genre,
                price);
    }

    public Book(
            String name,
            String author,
            int year,
            BookGenre genre,
            float price) {

        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
