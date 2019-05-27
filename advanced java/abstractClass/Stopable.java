package main.advanced.abstractClass;

public interface Stopable {

    public static final String message = "STOPPED!";

    // 1. abstract method; need implementation
    public void stop(int secondsDelay);

    // 2. default - has body
    public default String getInfo(){
        return "car info";
    }

    // 3. static
    public static String getDefaultInfo(){
        return "car default info (static)";
    }

}
