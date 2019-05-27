package main.advanced.generics;

import main.fundamentals.bank.Employer;
import main.fundamentals.bank.Person;
import org.junit.jupiter.api.Test;

public class BoxTest {

    @Test
    public void test_box(){

        Box myBox = new Box("string box", 100);

        Box yourBox = new Box(
                new Person("Ada", Employer.Azets, "Timisoara"),
                200);

        System.out.println("myBox:");
        Object myString = myBox.getItem();
        System.out.println(myString);
        Object myInt = myBox.getItem2();
        System.out.println(myInt);


        System.out.println("\nyourBox:");
        Object yourPerson = yourBox.getItem();
        Object yourInt = yourBox.getItem2();
        System.out.println(yourPerson);
        System.out.println(yourInt);

        System.out.println(
                ((Person)yourPerson).getName());

        // wrong cast - no error from compiler; throws exception at runtime
        System.out.println(
                ((Person)yourInt));

    }
}
