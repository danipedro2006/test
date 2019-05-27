package main.advanced.threads;

public class MyThreadTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("<<< start main thread");
        MainThreadTest.printThreadInfo();


        MyThread myThread1 = new MyThread();

        Thread myThread2 = new Thread(new MyOddThread());

        myThread1.start();

        myThread2.start();

        Thread.sleep(500);

        System.out.println("end main thread >>>");
    }

}
