package main.advanced.composition;

import main.advanced.inheritance.Car;
import main.advanced.inheritance.Plane;
import org.junit.jupiter.api.Test;

public class VechiclesTest {

    @Test
    public void test(){

        Vechicles vechicles = new Vechicles(

                new Car(200, "Honda", false),

                new Plane(500, "Phantom")

        );

        System.out.println(vechicles);
    }
}
