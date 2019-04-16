package project;

import java.util.ArrayList;
import java.util.List;

public class InvestmentCompany
{
    public static void main(String args[])
    {
        InvestmentCompany ic=new InvestmentCompany();
        ProiectSoftware o1=new proiectOpenSource("p1", "o1", 21, "mailList");

        o1.addMember(new Member());
        o1.addMember(new Member());
        ic.addproject(o1);
        ProiectSoftware o2=new proiectOpenSource("p2", "o2", 33, "mailList");
        o2.addMember(new Member());
        o2.addMember(new Member());
        ic.addproject(o2);
        System.out.println(ic.getBestInvestment().getRisk());
    }

    List<ProiectSoftware>proiecte=new ArrayList<ProiectSoftware>();
    public void addproject(ProiectSoftware proj)
    {
        proiecte.add(proj);
    }
    public ProiectSoftware getBestInvestment()
    {
        double Rezultat=proiecte.get(0).getRisk();
        int index=0;

        for(int i=1;i<proiecte.size();i++)
        {
            if(proiecte.get(i).getRisk()<Rezultat)
            {
                index=i;
                Rezultat=proiecte.get(i).getRisk();
            }
        }
        return proiecte.get(index);
    }

}