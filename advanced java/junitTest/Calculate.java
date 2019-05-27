package main.advanced.junitTest;

import java.util.List;

public class Calculate {

    private List<Integer> numbers;
    private static final String INFO_SUFFIX = "***INFO: ";


    public Calculate(List<Integer> numbers) {

        this.numbers = numbers;
    }

    public static String info(String message) {

        final String infoMessage = String.format("%s%s",
                INFO_SUFFIX,
                message);

        String info = String.join("",
                INFO_SUFFIX,
                message);

        String info2 = INFO_SUFFIX + message;

        return infoMessage;
    }


    public List<Integer> getNumbers() {

        return numbers;
    }


    public float getResult(OperationType operationType) {

        switch (operationType) {

            case SUM:
                return sum(numbers);

            case MULTIPLICATION:
                return multiplication(numbers);

            case AVERAGE:
                return average(numbers);

            default:
                throw new RuntimeException("wrong operation");
        }
    }



    public float sum(List<Integer> numbers) {

        float finalResult = 0;

        for (int i = 0; i < numbers.size(); i++) {
            finalResult += numbers.get(i);

        }

        return finalResult;
    }


    private float multiplication(List<Integer> numbers) {

        float finalResult = 1;

        for (int i = 0; i < numbers.size(); i++) {
            finalResult *= numbers.get(i);

        }

        return finalResult;
    }


    private float average(List<Integer> numbers) {

        return sum(numbers)/numbers.size();
    }


/*
    //TODO - check this failure
    @Test
    public void test(){
        Assertions.assertEquals(
                26,
                sum(List.of(1, 2, 3, 5, 9, 1, 2, 3)));

    }*/

}
