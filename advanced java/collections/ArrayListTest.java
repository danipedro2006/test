package main.advanced.collections;

import main.fundamentals.bank.Employer;
import main.fundamentals.bank.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    private static List<Integer> numbers;
    private static List<Person> listOfPersons;


    @BeforeAll
    public static void beforeAll() {

        // fixed size
        listOfPersons = Arrays.asList(
                new Person("Ada", Employer.Azets, "Timisoara"),
                new Person("Maria", Employer.Azets, "Timisoara"),
                new Person("Tania", Employer.Azets, "Timisoara")
        );

        // fixed size
        numbers = Arrays.asList(10, 11, 45, 99, 333, 9);
    }


    @Test
    public void test_initial_lists() {

        System.out.println(numbers.getClass().getName());
        System.out.println(numbers.getClass().getSimpleName());

        System.out.println(listOfPersons.getClass().getName());
        System.out.println(listOfPersons.getClass().getSimpleName());

        System.out.println("Initial lists:");
        System.out.println(numbers);
        System.out.println(listOfPersons);
    }


    @Test
    public void test_operations_lists() {

        List<Integer> ints = new ArrayList<>();
        //ArrayList<Integer> ints = new ArrayList<>();

        ints.addAll(numbers);

        ints.add(100);
        //ints.add(ints.size(), 100);

        // add at index
        ints.add(0, -1);
        System.out.println(ints);

        // get element from index
        System.out.println("element from index 1: "
                + ints.get(1));

        System.out.println("List size: "
                + ints.size());

        // contains
        System.out.println("Numbers list contains 99: "
                + ints.contains(99));
        System.out.println("Numbers list contains 55: "
                + ints.contains(55));

        // remove from index
        Integer removedElement = ints.remove(0);
        System.out.println("Removed element: " + removedElement);
        System.out.println("List after remove from index 0: " + ints);


        // remove from index
        int numberToRemove = 99;
        Integer numberToRemoveBoxed = Integer.valueOf(99);
        int unboxedInteger = numberToRemoveBoxed.intValue();

        float f = 99f;
        Float boxedFloat = Float.valueOf(f);
        int intValueOfFloat = boxedFloat.intValue();
        float unboxedFloat = boxedFloat.floatValue();



        ints.remove(Integer.valueOf(intValueOfFloat));

        boolean isRemoved = ints.remove(Integer.valueOf(100));

        System.out.println("Removed: " + isRemoved);
        System.out.println("List after removing 99, 100: " + ints);
    }


    @Test
    public void test_iteration_lists() {

        // method 1 - no index needed
        for (int number : numbers) {
            System.out.println(number);
        }

        // method 2 - can use also the index
        for (int index = 0; index < numbers.size(); index++) {

            Integer number = numbers.get(index);

            System.out.println("Index: " + index
                    + " value: " + number);
        }

        // method 3 - lambda
        numbers.forEach(System.out::println);
    }



}
