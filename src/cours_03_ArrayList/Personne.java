package cours_03_ArrayList;

public class Personne {
    public int getNo() {
        return no;
    }

    private int no;
    private String nom;
    private String prenom;
    private static int dernierNo = 0;

    public Personne(String nom, String prenom) {
        this.no = ++dernierNo;
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

    public void setNom(String newNom) {
        nom = newNom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        return no == personne.no;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "no=" + no +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}