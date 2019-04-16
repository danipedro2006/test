package project;

public abstract class Proiectcomercial extends ProiectSoftware
{
    public final int echipe;
    public final long fonduriDemarketing;
    public Proiectcomercial(String titlu, String obiectiv, int fonduri, int echipe)
    {
        super(titlu,obiectiv,fonduri);
        this.echipe = echipe;
        this.fonduriDemarketing=fonduri/2;
    }

        public double getRisk()
        {
        return echipe*3/getNumarMembrii()/fonduri-fonduriDemarketing;
        }
}
