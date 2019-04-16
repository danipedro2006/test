package project;

public abstract class ProiectMilitar extends propietarySoftwareProject {

    private final String parola;

    public ProiectMilitar(String titlu, String obiectiv, int fonduri, String deadline, String parola) {
        super(titlu, obiectiv, fonduri, deadline);
        this.parola = parola;
    }

    public double getRisk() {
        return getNumarMembrii() / parola.length() / fonduri;
    }
}





