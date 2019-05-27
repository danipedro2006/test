package main.advanced.enums;

import org.junit.jupiter.api.Test;

public class ConstructorTest {


    @Test
    public void test(){

        System.out.println(LengthUnit.FOOT);

        String sUnit = "INCH";
        System.out.println(LengthUnit.valueOf(sUnit));



        // print all 'to meter' conversion factors
        for(LengthUnit unit : LengthUnit.values()){

            System.out.println(unit);
        }

        float cmLength = 1000;
        System.out.println(cmLength + " cm ---> "
                + convertToMeter(cmLength, LengthUnit.CENTIMETER) + " m");


        float inchLength = 1000;
        System.out.println(inchLength + " inch ---> "
                + convertToMeter(inchLength, LengthUnit.INCH) + " m");
    }



    public float convertToMeter(float fromLength, LengthUnit fromUnit){

        return fromLength * fromUnit.getToMeterConversionFactor();
    }



    // homework
    // Create a method that can convert a length from a specified LenghtUnit to another one

}
