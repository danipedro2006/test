package com.company;

public class Dulap
{
    Sertar PrimulSertar;
    Sertar AlDoileaSertar;

    public  Dulap(Sertar PrimulSertar, Sertar AlDoileaSertar)
    {
        this.PrimulSertar = PrimulSertar;
        this.AlDoileaSertar = AlDoileaSertar;

    }


    public void afisare(Sertar SertarprimulSertar, Sertar alDoileaSertar)
    {

        System.out.println("Lungime= "+PrimulSertar.Lungime);
        System.out.println("Latime= "+PrimulSertar.Latime);
        System.out.println("Lungime= "+(int)(PrimulSertar.Inaltime+AlDoileaSertar.Inaltime));
    }
}
