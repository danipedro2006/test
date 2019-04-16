package project;

public abstract class propietarySoftwareProject extends ProiectSoftware
{
   public final int numarMaxim=15;
   public final String deadline;

   public propietarySoftwareProject(String titlu, String obiectiv, int fonduri, String deadline)
    {
        super(titlu, obiectiv, fonduri);
        this.deadline=deadline;
    }
    public void addMember(Member m)
    {

    }
    //public double getRisk()
//    {
//        return 0;
//    }

    public void addmember(Member m)
    {
        if(getNumarMembrii()<numarMaxim)
        {
            super.addMember(m);
        }
    }
}
