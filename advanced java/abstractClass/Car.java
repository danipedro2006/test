package main.advanced.abstractClass;

// can extend only one class
// can implement multiple interfaces
public class Car

        extends VehicleAbstract

        implements Stopable, Startable{


    private boolean isConvertible;

    public Car(int maxSpeed, String name, boolean isConvertible) {
        super(maxSpeed);
        this.isConvertible = isConvertible;
    }


    public boolean isConvertible() {
        return isConvertible;
    }


    @Override
    public String toString(){
        return //"Car with maxspeed " + maxSpeed
               super.toString()
                + ", convertible: " + isConvertible;
    }


    @Override
    public void move() {
        System.out.println("car moved");
    }


    @Override
    public void start() {
        System.out.println(Startable.message);
    }

    @Override
    public void stop(int secondsDelay) {
        System.out.println(Stopable.message + " after " + + secondsDelay + " seconds");
    }
}
