package cours_15a_tableauObjets_classeComparaisonPourTrier;

public class Sportif extends Personne {
    private String sport;
    public Sportif(String nom, String prenom, String sport) {
        super(nom, prenom);
        setSport(sport);
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        String str;

        str = super.toString(); //appelle to toString de sa classe parent
        str += " et mon sport est : " + sport;

        return str;
    }

    @Override
    public String crier() {
        return "Yes!!!!";
    }

}
