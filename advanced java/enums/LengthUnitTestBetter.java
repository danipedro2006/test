package main.advanced.enums;

import org.junit.jupiter.api.Test;


public class LengthUnitTestBetter {

    @Test
    public void enum_test() {

        // handled in switch
        System.out.println(getUnit(LengthUnit.INCH));

        // not handled in switch
        System.out.println(getUnit(LengthUnit.METER));

        System.out.println(getUnit(LengthUnit.FOOT));


    }


    public String getUnit(LengthUnit unit) {

        switch (unit) {

            case FOOT:

                return "Foot unit is selected";

/*            case METER:
                return "Meter unit is selected";
                */

            case INCH:

                return "Inch unit is selected";

            case CENTIMETER:

                return "Centimeter unit is selected";
                 

            default:

                return "Unknown unit";
        }

    }
}
