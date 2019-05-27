package main.advanced.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class ThrowablesTest {


    @Test
    public void runtime_exceptions_test() {

        String name = getValue();

        System.out.println(name.toUpperCase());

    }


    @Test
    public void wrong_file_exception_test() throws IOException {

        String fileName = "C:\\wrongPath\\file.txt";

        Files.readAllLines(Paths.get(fileName));

    }

    @Test
    public void assertion_error_test() throws IOException {

        Assertions.assertEquals("Maria", "maria");
    }


    @Test
    public void assertion_error_handle_test() throws IOException {

        try {

        }
        // could also use any AssertionFailedError parrent class
        // Throwable <- Error <- AssertionFailedError
        catch (AssertionFailedError afe) {
            System.out.println(afe.toString());
        }
    }


    private String getValue() {
        // calculations
        return null;
    }


    @Test
    public void divide_by_0_test() {

        System.out.println(divide(5, 0));
    }

    @Test
    public void divide_by_test() {

        System.out.println(divide(6, 2));
    }


    public int divide(int number, int divider) {

        try {
            return number / divider;

        } catch (Exception e) {
            System.out.println("Custom message: " + e);
            throw e;
        }

        finally {
            System.out.println("Divide executed");
        }
    }


    @Test
    public void multiple_exceptions_test() {

        int[] intArray = new int[10];
        for(int i = 0; i < 10; i++){
            intArray[i] = i * 10;
        }

        System.out.println(Arrays.toString(intArray));


        try {

            // for ArrayIndexOutOfBoundsException
            int x = intArray[10] / 0;

            // for ArithmeticException
            //int x = intArray[9] / 0;

            // for another exception catch
            //int x = intArray[9] / 1;
            //throw new Exception("NEW");

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught!");
            System.out.println(e);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndex(...)Exception caught!");
            System.out.println(e);

        } catch (Exception e) {
            System.out.println("Another exception caught!");
            System.out.println(e);
        }
    }


    @Test
    public void multiple_exceptions_test_OR() {

        int[] intArray = new int[10];
        for(int i = 0; i < 10; i++){
            intArray[i] = i * 10;
        }

        System.out.println(Arrays.toString(intArray));


        try {

            // for ArrayIndexOutOfBoundsException
            // int x = intArray[10] / 0;

            // for ArithmeticException
            int x = intArray[9] / 0;

            // for another exception catch
            //int x = intArray[9] / 1;
            //throw new Exception("NEW");

        } catch (ArithmeticException
                | ArrayIndexOutOfBoundsException e) {
            System.out.println("ArithmeticException or " +
                    "ArrayIndexOutOfBoundsException caught!");
            System.out.println(e);

        } catch (Exception e) {
            System.out.println("Another exception caught!");
            System.out.println(e);
        }
    }
}
