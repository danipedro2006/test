package main.advanced.abstractClass;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AbstractTest {

    static VehicleAbstract vehicle;
    static Car car;


    @BeforeAll
    public static void beforeAll(){

        // abstracted cannot be instantiated
        // vehicle = new Vehicle(150);

        car = new Car(200, "", true);
    }


    @Test
    public void abstract_inheritance_test(){

        System.out.println(car);

        car.start();

        // abstracted method from Vehicle, implemented in Car
        // move is an instance method (need new Car() before
        car.move();

        // implemented abstract
        car.stop(100);

        // default (not overrided in Car)
        System.out.println(car.getInfo());

        System.out.println(Stopable.getDefaultInfo());


        // start is a Type/Class method; it does not deen an instance
        System.out.println(VehicleAbstract.startVechicle());


    }


}
