package main.advanced.generics;

import main.fundamentals.bank.Employer;
import main.fundamentals.bank.Person;
import org.junit.jupiter.api.Test;

public class BoxGenericTest {

    @Test
    public void test_generic_box(){

        BoxGeneric<String, Integer> myBox = new BoxGeneric<>(
                "string box",
                100);

        BoxGeneric<Person, Integer> yourBox = new BoxGeneric<>(
                new Person("Ada", Employer.Azets, "Timisoara"),
                200);


        System.out.println("myBox:");
        String myString = myBox.getItem();
        System.out.println(myString);
        Integer myInt = myBox.getItem2();
        System.out.println(myInt);


        System.out.println("\nyourBox:");
        Person yourPerson = yourBox.getItem();
        Integer yourInt = yourBox.getItem2();
        System.out.println(yourPerson);
        System.out.println(yourInt);


        System.out.println(yourPerson.getName());

        // wrong cast - no error from compiler; throws exception at runtime
        System.out.println(yourInt);

    }
}
