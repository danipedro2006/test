package main.advanced.lambda;

import java.util.List;

public class ConsumerTest {

    private static class Number{

        public int value;

        public Number(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public static void main(String[] args) {

        // immutable list (objects in list are not immutable)
        List<Number> numbers = List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4)
        );

        // consumer acts by mutation
        numbers.forEach(n -> {
            n.value++;
        });

        System.out.println(numbers);
    }
}
