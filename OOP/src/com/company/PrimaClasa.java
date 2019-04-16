package com.company;

public class PrimaClasa
{
    int numar;
    String text;

    public PrimaClasa (int numar, String text)
    {
        this.numar=numar;
        this.text=text;
    }

    public void afiseaza()

    {
        System.out.println("numar= "+numar);
        System.out.println("text= "+text);
    }
}
