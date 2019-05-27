package main.advanced.exceptions;


public class Car {

    private int speed;


    public Car(int speed) {
        this.speed = speed;
        System.out.println("Initial speed: " + speed);
    }


    public void increaseSpeed(int increment) throws CarCrashException {

        speed += increment;
        System.out.println("speed increased to  " + speed);

        if (speed < 50){
            throw new CarCrashException("WARNING: driving to slow can also cause crashes");
        }


        if (speed > 200) {
            throw new CarCrashException();
        }


    }


    public void drive(String town) {
        System.out.println("Car drived to " + town + " with speed " +  speed);
    }
}
