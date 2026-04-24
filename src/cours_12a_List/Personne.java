package cours_12a_List;

import java.time.LocalDate;

public class Personne {
    private String nom;
    private String prenom;
    private final LocalDate dateNaissance;

    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
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

    public void setNom(String newNom) {
        nom = newNom;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Personne personne = (Personne) object;
        return nom.equals(personne.nom) && prenom.equals(personne.prenom) && dateNaissance.equals(personne.dateNaissance);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
}