package cours_04_Heritage;

import java.util.Objects;

public class Personne {
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

    public void set(Personne p){
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
        return "Mon nom est " + prenom + " " + nom + " ";
    }
}