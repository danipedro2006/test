package main.advanced.lambda;

public class RunTaskTest {

    public static void main(String[] args) {

        execute(new RunTask());

        final Runnable runnable = () -> {
            System.out.println("Lambda Runnable instance.");
        };

        execute(runnable);
    }


    public static void execute(Runnable runnable){
        runnable.run();
    }
}
