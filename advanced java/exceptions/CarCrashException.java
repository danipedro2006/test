package main.advanced.exceptions;

public class CarCrashException extends Exception{

    public CarCrashException() {
        super("TOO MUCH SPEED!");
    }


    public CarCrashException(String message) {
        super(message);
    }
}
