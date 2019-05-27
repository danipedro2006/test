package main.advanced.exceptions;

public class CarTest {


    public static void main(String[] args) throws CarCrashException {

        Car car = new Car(30);


        try {
            car.increaseSpeed(10);
        } catch (CarCrashException e) {

            System.out.println(e.getMessage());
        }


        car.increaseSpeed(100);

        car.increaseSpeed(80);

        car.drive("Timsoara");
    }
}
