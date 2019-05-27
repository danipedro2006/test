package main.advanced.lambda;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

public class OperationTest {

    public static void main(String[] args) {

        //final int sum = new Sum().operate(10, 20);
        System.out.println("Named class that implements the Functional Inteface Operation");
        printOperationResult(10, 20 , new Sum());

        final Multiply multiplyInstance = new Multiply();

        // method reference
        // :: operator
        printOperationResult(10, 20 , multiplyInstance::operate);

        //Operation.info();


        System.out.println("\n\nLAMBDA");
        // Sum
        printOperationResult(
                10, 20 ,
                (a, b) -> a + b);

        // Multiply
        final Operation<Integer> multiplication = (a, b) -> { return a * b; };

        printIntegerOperationResult(10, 20, multiplication);


        //final Operation<Float> division = (a, b) -> a / b;

        printOperationResult(
                20f, 5f ,
                (a, b) -> a / b);


        final Operation<Integer> lambdaOperation = (a, b) -> {
            System.out.println("lambda intern text");
            return a + 2 * b;
        };

        printOperationResult(20, 5 , lambdaOperation);

    }


    @Test
    public void test(){

        printUnaryOperationResult(
                5f,
                price -> new Product("vcr", 2, price));

        Function<Integer, Integer> duplicate = x -> x * 2;

        List.of(1,2,3,4,5,6,7).stream()
               .map(duplicate)
               .forEach(System.out::println);


    }

    private static <T> void printOperationResult(
            T first,
            T second,
            Operation<T> operation){

        System.out.println(operation.operate(first, second));
    }


    private static <T,R> void printUnaryOperationResult(
            T number,
            Function<T, R> operation){

        System.out.println("" + operation.apply(number));
    }


    private static void printIntegerOperationResult(
            Integer first,
            Integer second,
            Operation<Integer> operation){

        System.out.println(operation.operate(first, second));
    }



}
