package cours_22_fichiers.c_fichierObjet.cb_Serialisation.Personne;

//La classe Employe hérite (extends) de Personne
public class Employe extends Personne {
    private int salaire;
    public Employe(String nom, String prenom) {
        super(nom, prenom); //Appelle le constructeur parent. Doit être la première instruction du constructeur.
    }

    public Employe(String nom, String prenom, int salaire) {
        super(nom, prenom);
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        String str;

        str = super.toString(); //appelle le toString de sa classe parent
        str += " et mon salaire est : " + salaire;

        return str;
    }

    @Override
    public String crier() {
        return "Let's go gang!";
    }

    @Override
    public int compareTo(Personne p) {
        int valeurComparaison = super.compareTo(p);
        if (valeurComparaison == 0) {
            valeurComparaison = Integer.compare(this.salaire, ((Employe)p).salaire); //xxx
        }
        if (valeurComparaison == 0) {
            valeurComparaison = getNom().compareTo(p.getPrenom());
        }

        return valeurComparaison;
    }
}
