package main.advanced.inheritance;

public class Car extends Vehicle {

    private boolean isConvertible;

    public Car(int maxSpeed, String name, boolean isConvertible) {
        super(maxSpeed, name);
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


}
