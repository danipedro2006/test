package main.advanced.bookStore;

import java.io.IOException;
import java.nio.file.Paths;

import static main.advanced.bookStore.BookGenre.*;

public class BookStoreApplication {


    public static void main(String[] args) throws IOException {

        // ###1
        BookStore bookStore = new BookStore();

        // ###2
        bookStore.addBook(new Book(
                "The Hunger Games",
                "Suzanne Collins",
                2008,
                FICTION,
                11.25f),
                1);

        bookStore.addBook(new Book(
                "Beautiful Disaster",
                "Suzanne Collins",
                2011,
                 ROMANCE,
                12.34f),
                2);

        bookStore.addBook(new Book(

                // TODO chech nullpointer exeception for "    A Wrinkle in Time",
                "A Wrinkle in Time",
                "Madeleine L'Engle",
                1973,
                CHILDREN,
                11.97f),
                5);

        System.out.println(bookStore);
        System.out.println("--------------------------------------------------");

        bookStore.addBook(Paths.get(
                "Resource/Advanced/bookStore/books.txt"));

        System.out.println(bookStore);

        System.out.println("#4 SEARCHES----------------------------------------");
        // TODO HOMEWORK

        System.out.println("#5 SEARCHES----------------------------------------");
        // TODO HOMEWORK



    }



}
