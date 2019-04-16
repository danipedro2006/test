package com.company;

public class NumarComplex
{
    int a=0;
    int b=0;
    public NumarComplex()
    {

    }

public NumarComplex(int a, int b)
{
    this.a=a;
    this.b=b;
}


public void afiseazaNumar()
{
    System.out.println(a+"+"+b+"i");

}

public void addcplx( NumarComplex n, NumarComplex m)
{
    int c=n.a+m.a;
    int d=n.b+m.b;
    System.out.println(c+"+"+d+"i");

}
    public  NumarComplex add2cplx( NumarComplex n, NumarComplex m)
    {

        NumarComplex r=new NumarComplex(n.a+m.a, n.b+m.b);
        return r;
    }
}
