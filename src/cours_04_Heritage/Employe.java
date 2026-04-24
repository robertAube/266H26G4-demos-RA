package cours_04_Heritage;

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
        return super.toString() + " et j'ai un salaire de " + salaire;
    }
}
