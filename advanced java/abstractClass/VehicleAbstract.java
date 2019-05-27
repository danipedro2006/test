package main.advanced.abstractClass;

public abstract class VehicleAbstract {

    private int maxSpeed;

    public VehicleAbstract(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }


    @Override
    public String toString(){
        return "Vehicle with maxspeed " + maxSpeed;
    }


    public static String startVechicle(){
        return "Vehicle started";
    }

    // no body -> class must be abstarct
    public abstract void move();
}