package main.advanced.lambda;

public class RunTask implements Runnable {

    @Override
    public void run() {

        System.out.println("Run first task within runnable.");
    }
}
