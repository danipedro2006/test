package project;

public class proiectOpenSource extends ProiectSoftware
{
    public final String mailingList;
    public proiectOpenSource(String titlu, String obiectiv, int fonduri, String mailingList)
    {
        super(titlu,obiectiv, fonduri);
        this.mailingList=mailingList;
    }
     public double getRisk()
    {
       return (double)this.getNumarMembrii()/fonduri;
    }
}

