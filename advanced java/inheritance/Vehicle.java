package main.advanced.inheritance;

public class Vehicle {

    private int maxSpeed;
    private String name;

    public Vehicle(int maxSpeed, String name) {
        this.maxSpeed = maxSpeed;
        this.name = name;
    }

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString(){
        return "Vehicle named " + name + " with maxspeed " + maxSpeed;
    }

    public String getName() {
        return name;
    }

}
