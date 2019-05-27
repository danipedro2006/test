package main.advanced.threads;

public class MainThreadTest {


    public static void main(String[] args) {

        System.out.println("<<< start main thread");

        printThreadInfo();

        System.out.println("end main thread >>>");
    }


    public static void printThreadInfo() {

        final Thread currentThread = Thread.currentThread();

        System.out.println("***** Thread");
        System.out.println("Id: " + currentThread.getId());
        System.out.println("Name: " + currentThread.getName());
        System.out.println("State: " + currentThread.getState());

        System.out.println("Stack: ");
        StackTraceElement[] stackElements = currentThread.getStackTrace();
        for (StackTraceElement elem : stackElements){
            System.out.println(elem);
        }
        System.out.println("*****");

    }



}
