package cours_05_Interface_classe_abstraite;

//La classe Employe hérite (extends) de Personne
public class Employe extends Personne {
    private double salaire;
    public Employe(String nom, String prenom) {
        super(nom, prenom); //Appelle le constructeur parent. Doit être la première instruction du constructeur.
    }

    public Employe(String nom, String prenom, double salaire) {
        super(nom, prenom);
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        String str;

        str = super.toString(); //appelle le toString de sa classe parent
        str += this.getClass().getSimpleName(); //Retourne le nom de la classe
        str += " et mon salaire est : " + salaire;

        return str;
    }

    @Override
    public String crier() {
        return "Let's go gang!";
    }
}
