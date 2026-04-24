package cours_22_fichiers.c_fichierObjet.cb_Serialisation.Personne;

import java.io.Serializable;
import java.util.Objects;

//Mot clé abstract :
// on ne peut pas instancier cette classe.
// On pourrait dire qu'elle est incomplète parce qu'elle n'implémente pas l'interface
public abstract class Personne implements iCriable, Comparable<Personne>, Serializable {
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void set(Personne p) {
        setNom(p.nom);
        setPrenom(p.prenom);
    }

    public void setNom(String newNom) {
        nom = newNom;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Personne personne = (Personne) object;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom);
    }

    @Override
    public String toString() {
        String str;

        str = "Mon nom est " + prenom + " " + nom + ". ";
        str += "Je suis un " + this.getClass().getSimpleName(); //Retourne le nom de la classe

        return str;
    }

    @Override
    public int compareTo(Personne p) {
        return this.getClass().getSimpleName().compareTo(p.getClass().getSimpleName());
    }
}