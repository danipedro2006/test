package main.advanced.streams;

import main.fundamentals.bank.Employer;
import main.fundamentals.bank.Person;
import main.fundamentals.bank.Persons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class BasicStreamTest {

    List<Person> employees;

    final Predicate<Person> isPersonFromTimisoara =
            person -> person.getLocation().equals("Timisoara");

    final BiPredicate<Person, String> isPersonFromTownBiPredicate =
            (person, town) -> person.getLocation().equals(town);

    final public Predicate<Person> isPersonFromIbm =
            p -> p.getEmployer().equals(Employer.IBM);


    @BeforeEach
    public void before() throws IOException {

        employees = Persons.fileToPersonList(
                "Resource\\Fundamentals\\Bank\\employees.csv");

    }


    @Test
    public void test_stream_filter_fromTm_expanded() {

        Stream<Person> employeesStream = employees.stream();

        final Predicate<Person> isPersonFromTimisoara = person -> person.getLocation().equals("Timisoara");

        Stream<Person> employeesFromTmStream = employeesStream.filter(isPersonFromTimisoara);

        List<Person> employeesFromTmList = employeesFromTmStream.collect(toList());

        //employeesFromTmList.forEach(System.out::println);
        employeesFromTmList.forEach( p -> { System.out.println(p); });
    }


    @Test
    public void test_stream_filter_fromTm_short() {

        employees.stream()
                .filter(p -> isPersonFromTown(p, "Timisoara"))
                .collect(toList())
                .forEach(System.out::println);
    }

    @Test
    public void test_stream_filter_fromBv_short() {

        employees.stream()
                //.filter(person -> person.getLocation().equals("Brasov"))
                .filter(person -> isPersonFromTown(person, "Brasov"))
                //.filter(person -> isPersonFromTownBiPredicate.test(person, "Brasov"))
                .collect(toList())
                .forEach(System.out::println);
    }


    public boolean isPersonFromTown(Person person, String town){

        return person.getLocation().equals(town);
    }

    public boolean isPersonFromTimisoara(Person person){
        return isPersonFromTown(person, "Timisoara");
    }


    @Test
    public void test_stream_filter_and_count(){

        Long employeesFromTimisoaraCount = employees.stream()

                .filter(p -> p.getLocation().equals("Timisoara"))

                .filter(p -> p.getEmployer().equals(Employer.IBM))

                .collect(counting());

        System.out.println("employeesFromVismaTimisoaraCount: " + employeesFromTimisoaraCount);

    }


    @Test
    public void test_names_from_IBM_Timisoara(){

        String namesFromIBMTimisoara = employees.stream()

                .filter(isPersonFromTimisoara) // predicate field from this class
                //.filter(this::isPersonFromTimisoara)  // method from this class

                .filter(isPersonFromIbm)

                //.map(person -> person.getName())  // lambda
                .map(Person::getName) // method reference

                .collect(Collectors.joining(" , "));



        System.out.println("namesFromIBMTimisoara: " + namesFromIBMTimisoara);
    }


    @Test
    public void test_concatenate_streams(){

        Stream<Person> employeesFromTimisoaraStream = employees.stream()
                .filter(isPersonFromTimisoara);

        Stream<Person> employeesFromBrasovStream = employees.stream()
                .filter(p -> isPersonFromTown(p, "Brasov"));

        Stream<Stream<Person>> streamOfStreams = Stream.of(
                employeesFromTimisoaraStream,
                employeesFromBrasovStream);

        //emplFromTmAndBvStreamOfStreams.forEach(x -> System.out.println(x));

        streamOfStreams
                .flatMap(i -> i)
                .collect(Collectors.toList())
                .forEach(System.out::println);



    }

    @Test
    public void test_concatenate_streams2(){

        List<Integer> numbers1 = List.of(1,3,5,7,9);
        List<Integer> numbers2 = List.of(0,2,4,6,8,10);
        List<Integer> numbers3 = List.of(0, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 11);

        // Stream<Integer> stream1 = numbers1.stream();
        Stream<Integer> stream1 = Stream.of(1, 3, 5, 7, 9);

        Stream<Integer> stream2 = numbers2.stream();

        Stream<Integer> stream3 = numbers3.stream();

        /*Stream<Stream<Integer>> all = Stream.of(stream1, stream2);
        Stream<Integer> allNumbersStream = all.flatMap(i -> i);
        List<Integer> allNumbersList = allNumbersStream.collect(toList());*/

        List<Integer> allNumbersList = Stream.of(stream1, stream2, stream3)
                .flatMap(i -> i)
                .collect(toList());

        System.out.println(allNumbersList);


        Set<Integer> allNumbersSet = Stream.of(
                numbers1.stream(),
                numbers2.stream(),
                numbers3.stream())

                .flatMap(i -> i)

                .collect(Collectors.toSet());

        System.out.println(allNumbersSet);

    }






}


