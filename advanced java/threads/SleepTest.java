package main.advanced.threads;

public class SleepTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread starts");

        for(int i = 0; i <= 6; i+=2){

            int miliSeconds = i * 1000;

            System.out.println(String.format(
                    "waiting for %s seconds ...",
                    i));

            Thread.sleep(miliSeconds);
        }

        System.out.println("Main thread ends");
    }

}
