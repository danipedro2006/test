package main.advanced.bookStore;

import org.junit.jupiter.api.*;

public class BookTest {


    private Book book1;
    private Book book1Copy;
    private Book book1CopyWithDifferentPrice;


    @BeforeEach
    public void beforeEach() {

        book1 = new Book(
                "name2",
                "author",
                2000,
                BookGenre.CHILDREN, 100f);

        book1Copy = new Book(
                "name2",
                "author",
                2000,
                BookGenre.CHILDREN, 100f);

        book1CopyWithDifferentPrice = new Book(
                "name2",
                "author",
                2000,
                BookGenre.CHILDREN, 101f);

    }


    @Test
    public void toString_test() {

        Assertions.assertEquals(
                " |                     name2 |                    author | 2000 |   CHILDREN | 100.00",
                book1.toString());
    }


    @Nested
    class EqualsTest {

        @Test
        void positive_same_objects_test() {

            Assertions.assertEquals(
                    true,
                    book1.equals(book1));
        }


        @Test
        void positive_different_objects_test() {

            Assertions.assertEquals(
                    true,
                    book1.equals(book1Copy));

        }


        @Test
        void negative_test() {

            Assertions.assertEquals(
                    false,
                    book1.equals(book1CopyWithDifferentPrice));

        }
    }


    @Test
    @Disabled
    void setPrice_test() {
        //TODO not implemented
    }
}
