package com.company;

public class PunctColorat extends Punct
{
    // int x; suprascrierea variabilelor
    //  int y;suprascrierea variabilelor

    String Culoare="Rosu";

    public PunctColorat(int x, int y, String culoare)

    {
        super(x,y);
        this.Culoare=culoare;

    }
    public String toString()
    {
        return super.toString()+"culoare= "+Culoare;//polimorfism
        //return "x= "+x+"y= "+y+"culoare= "+Culoare;
    }
}
