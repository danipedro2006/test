package main.advanced.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierAndConsumerTest {

    private static String info = "SupplierAndConsumerTest";


    public static void main(String[] args) {

        Supplier<String> generateMessage = () ->

                info + " thread: " + Thread.currentThread().getName();

        System.out.println("Supplier: " + generateMessage.get());


        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(10);
        numberList.add(100); // index 2
        System.out.println("Initial list: " + numberList);

        int listIndex = 1;

        Consumer<List<Integer>> numbersConsumer = numbers -> {
            System.out.println(numbers.remove(listIndex));
            // no return
        };
        numbersConsumer.accept(numberList);

        System.out.println("List after using the consumer: " + numberList);

    }
}
