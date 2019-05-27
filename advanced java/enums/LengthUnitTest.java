package main.advanced.enums;

import org.junit.jupiter.api.Test;


public class LengthUnitTest {

    @Test
    public void enum_test() {

        // handled in switch
        System.out.println(getUnit(LengthUnit.INCH));

        // not handled in switch
        System.out.println(getUnit(LengthUnit.METER));

        // no break !!! WRONG !!!
        System.out.println(getUnit(LengthUnit.FOOT));


    }


    public String getUnit(LengthUnit unit) {

        String message;

        switch (unit) {

            case FOOT:
                message = "Foot unit is selected";
                //break;

/*            case METER:
                message = "Meter unit is selected";
                break;*/

            case INCH:
                message = "Inch unit is selected";
                break;

            case CENTIMETER:
                message = "Centimeter unit is selected";
                break;

            default:
                message = "Unknown unit";
        }

        return message;
    }
}
