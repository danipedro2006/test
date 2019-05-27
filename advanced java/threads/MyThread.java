package main.advanced.threads;

public class MyThread extends Thread {

    @Override
    public void run() {

        final long id = getId();

        final String name = getName();

        System.out.println("<<< start " + name + " " + id);

        // MainThreadTest.printThreadInfo();
        for(int i = 10; i < 50; i += 10){
            System.out.println(getName() + ": " + i);
        }

        System.out.println("end "  + name + " " + id + " >>>");
    }
}
