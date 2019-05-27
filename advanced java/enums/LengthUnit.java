package main.advanced.enums;

import java.util.Arrays;

public enum LengthUnit {

    METER(1),

    CENTIMETER(0.01f),

    FOOT(0.3f),

    INCH(0.025f);


    private float toMeterConversionFactor;


/*    LengthUnit() {
        setToMeterConversionFactor();
    }*/


    LengthUnit(float toMeterConversionFactor) {
        this.toMeterConversionFactor = toMeterConversionFactor;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                LengthUnit.values()));

        for (LengthUnit lengthUnit : LengthUnit.values()){
            System.out.println(lengthUnit);
        }
    }

    public float getToMeterConversionFactor(){

        return toMeterConversionFactor;
    }


    private void setToMeterConversionFactor(){

        switch (this){

            case METER:
                toMeterConversionFactor = 1f;
                break;

            case CENTIMETER:
                toMeterConversionFactor = 0.01f;
                break;

            case FOOT:
                toMeterConversionFactor = 0.3f;
                break;

            case INCH:
                toMeterConversionFactor = 0.025f;

                break;
        }
    }


    @Override
    public String toString(){
        return this.name() + ": " + toMeterConversionFactor;
    }
}