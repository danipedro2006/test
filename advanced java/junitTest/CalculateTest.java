package main.advanced.junitTest;

import org.junit.jupiter.api.*;

import java.util.List;

import static main.advanced.junitTest.OperationType.*;

public class CalculateTest {

    private static int testCounter = 1;

    private static Calculate calculate;

    static final List<Integer> testList1 = List.of(1, 2, 3, 5, 9, 1, 2, 3);

    static final float expectedSumResult = 26f;
    static final float expectedMultiplicationResult = 1620f;
    static final float expectedAverageResult = 3.25f;


    @BeforeAll
    public static void beforeAll(){

        calculate = new Calculate(testList1);
    }


    @BeforeEach
    public void beforeEach(){
        System.out.println("before each - test " + testCounter++);
    }


    @Nested
    @DisplayName("get result method TEST")
    class GetResultTest {

        @Test
        public void sum_test() {

            Assertions.assertEquals(
                    expectedSumResult,
                    calculate.getResult(SUM));
        }

        @Test
        //@DisplayName("MULTIPLICATION TEST FOR getResult method")
        public void multiplication_test() {

            Assertions.assertEquals(
                    expectedMultiplicationResult,
                    calculate.getResult(MULTIPLICATION));
        }


        @Test
        public void average_test() {

            Assertions.assertEquals(
                    expectedAverageResult,
                    calculate.getResult(AVERAGE));
        }
    }


    @Nested
    @DisplayName("INFO TEST")
    class InfoTest {

        @Test
        /* Requirement for Calculate.info method:
        For a specified message the info method returns a formatted text
        composed from the suffix "***INFO: " and the original message.
        */
        public void with_message_test() {

            final String message = "this is a class for calculations";

            String actualResult = Calculate.info(message);

            String expectedResult = "***INFO: " + message;

            Assertions.assertEquals(expectedResult, actualResult);
        }


        //@Test
        @RepeatedTest(3)
        public void without_message_test() {


            String actualResult = Calculate.info("");

            String expectedResult = "***INFO: ";

            Assertions.assertEquals(expectedResult, actualResult);
        }

    }
}
