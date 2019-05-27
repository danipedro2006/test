package main.advanced.lambda;

import main.fundamentals.bank.Employer;
import main.fundamentals.bank.Person;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperatorsTest {


    public static void main(String[] args) {

        UnaryOperator<Integer> duplicate = number -> number * 2;
        // same as above
        Function<Integer, Integer> duplicateFunction = number -> number * 2;

        Function<Integer, String> duplicateFunctionText = number -> "" + number + number;
        Function<Integer, String> duplicateFunctionText2 = number -> "" + number * 2;

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        final Stream<Integer> numbersStream = numbers.stream();

        List<String> concatenatedNumbers = numbersStream
                .map(duplicateFunctionText)
                .collect(Collectors.toList());

        List<String> duplicatedNumbers = numbers.stream()
                .map(duplicateFunctionText2)
                .collect(Collectors.toList());


        System.out.println("after applying duplicateFunctionText: " + concatenatedNumbers);

        System.out.println("after applying duplicateFunctionText2: " + duplicatedNumbers);


        UnaryOperator<Integer> toSquareUnaryOperator = i -> {
            int result = i * i;
            System.out.println("Result: " + result);
            return result;
        };

        UnaryOperator<Integer> toSquareUnaryOperator2 = number -> number * number;

        System.out.println(toSquareUnaryOperator.apply(4));
        System.out.println("Result 4^2: " + toSquareUnaryOperator2.apply(4));

        BinaryOperator<Float> sum = (float1, float2) -> float1 + float2;
        BinaryOperator<Float> multiply = (float1, float2) -> float1 * float2;
        BinaryOperator<Float> divide = (float1, float2) -> float1 / float2;


        System.out.println("Sum of 10 and 3" + sum.apply(10f, 3f));
        System.out.println("Multiplication of 10 by 3" + multiply.apply(10f, 3f));
        System.out.println("Division of 10 by 3" + divide.apply(10f, 3f));


        Person employeeFromTm = new Person("Mihai", Employer.Visma, "Timisoara");
        Person employeeFromSb = new Person("Carmen", Employer.Visma, "Sibiu");
        Person employeeFromBuc = new Person("Carmen", Employer.Visma, "Bucuresti");

        BinaryOperator<Person> getFirstPerson = (person1, person2) -> {

            final String name1 = person1.getName();
            final String name2 = person2.getName();

            if (name1.compareTo(name2) < 0) {
                return person1;
            } else if (name1.compareTo(name2) == 0) {
                if (person1.getLocation().compareTo(person2.getLocation()) < 0) {
                    return person1;
                }
                return person2;
            } else {
                return person2;
            }

        };

        System.out.println(getFirstPerson.apply(employeeFromTm, employeeFromSb));
        System.out.println(getFirstPerson.apply(employeeFromSb, employeeFromTm));

        System.out.println(getFirstPerson.apply(employeeFromSb, employeeFromBuc));
    }
}
