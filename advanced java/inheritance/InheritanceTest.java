package main.advanced.inheritance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class InheritanceTest {

    static Vehicle vehicle;
    static Vehicle car;


    @BeforeAll
    public static void beforeAll(){

        vehicle = new Vehicle(150);
        //Car car = new Car(200, true);
        car = new Car(200, "", true);
    }


    @Test
    public void inheritance_test(){


        System.out.println(vehicle);
        System.out.println(car);

        System.out.println("Vehicle");
        System.out.println(vehicle.getClass().getName());
        System.out.println(vehicle.getMaxSpeed());


        System.out.println("Car:");
        System.out.println(car.getClass().getName());
        System.out.println(car.getMaxSpeed());
        //System.out.println(car.isConvertible());
    }


    @Test
    public void polymorphism_test(){

        // invoke toString from Vehicle
        System.out.println(vehicle);

        // invoke toString from Car
        System.out.println(car);

        System.out.println("Car is convertible: " + ((Car)car).isConvertible());

    }

    @Test
    public void test_parameters(){

        print(car);
    }


    private void print(Vehicle vehicle) {

        System.out.println(vehicle);
    }
}
