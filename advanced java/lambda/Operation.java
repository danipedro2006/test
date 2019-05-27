package main.advanced.lambda;


// Functional Interface - only one abstract method (with no body)
public interface Operation<T> {

    // only ONE
    public T operate(T first, T last);

    static void info(){

        Runnable r;
        Comparable<String> c;

        System.out.println(Operation.class.getName());


    }
}
