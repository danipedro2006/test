package project;
import java.util.*;

public abstract class ProiectSoftware implements  Risky
{
    public final String titlu;
    public final String obiectiv;
    public final int fonduri;
    private int numarMembrii = 0;
    private List<Member> membrii = new ArrayList<Member>();
    //Member[] membrii=new Member[0];

    public ProiectSoftware(String titlu, String obiectiv, int fonduri)
    {
        this.titlu = titlu;
        this.obiectiv = obiectiv;
        this.fonduri = fonduri;
    }

    //public abstract double getRisk();
    public int getNumarMembrii()
    {
        return membrii.size();
    }


    public void addMember(Member m)
    {
        membrii.add(m);

    }
}
