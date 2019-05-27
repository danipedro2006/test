package main.advanced.threads;

public class MyOddThread implements Runnable {


    @Override
    public void run() {

        // differs from extending the Thread class
        Thread currentThread = Thread.currentThread();

        final long id = currentThread.getId();

        final String name = currentThread.getName();

        System.out.println("<<< start " + name + " " + id);

        // MainThreadTest.printThreadInfo();
        for(int i = 1; i < 20; i += 2){
            System.out.println(name + ": " + i);
        }

        System.out.println("end "  + name + " " + id + " >>>");
    }
}
