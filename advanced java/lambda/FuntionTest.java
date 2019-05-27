package main.advanced.lambda;

import main.fundamentals.bank.Employer;
import main.fundamentals.bank.Person;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FuntionTest {

    public static void main(String[] args) {

        Person person1 = new Person("Anda", Employer.Azets, "Timisoara");
        Person person2 = new Person("Mihai", Employer.Visma, "Timisoara");
        Person person3 = new Person("Carmen", Employer.Visma, "Sibiu");

        // FUNCTION
        Function<Person, String> getPersonInfo = person -> {
            return person.getName() + ": " + person.getLocation();
        };

        final String personInfo = getPersonInfo.apply(person1);

        System.out.println(personInfo);

        // BIFUNCTION
        BiFunction<Person, Person, Boolean> personsLiveInTimisoara =
                (p1, p2) -> p1.getLocation() == "Timisoara"
                            && p2.getLocation() == "Timisoara";

        BiFunction<Person, String, Boolean> personLivesInTown =
                (person, town) -> person.getLocation().equals(town);


        System.out.println("person1 and person2 live in Timisoara: "
                + personsLiveInTimisoara.apply(person1, person2));

        System.out.println("person1 and person3 live in Timisoara: "
                + personsLiveInTimisoara.apply(person1, person3));

        System.out.println("person1 lives in Timisoara: "
                + personLivesInTown.apply(person1, "Timisoara"));

        BiFunction<Person, String, Employer> getEmployerIfPersonLivesInLocation =
            (person, location) -> {
                if(person.getLocation().equals(location)){
                    return person.getEmployer();
                }
                return Employer.Unknown;
            };

        System.out.println("Employer of person1, if person1 lives in Timisoara, else Unknown: "
                + getEmployerIfPersonLivesInLocation.apply(
                person1,
                "Timisoara"));

        System.out.println("Employer of person1, if person3 lives in Timisoara, else Unknown: "
                + getEmployerIfPersonLivesInLocation.apply(
                person3,
                "Timisoara"));

        System.out.println("Employer of person3, if person3 lives in Sibiu, else Unknown: "
                + getEmployerIfPersonLivesInLocation.apply(
                person3,
                "Sibiu"));

    }


    public boolean personsLiveInTown(Person person, String town){

        return person.getLocation().equals(town);
    }

}
