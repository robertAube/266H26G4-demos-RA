package cours_17a_exercice;

import static java.lang.Math.random;

public class Etudiant implements Comparable<Etudiant> {
    private int noDA;
    private String nom;

    public Etudiant(int noDA, String nom) {
        this.noDA = noDA;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNoDA() {
        return noDA;
    }

    public void setNoDA(int noDA) {
        this.noDA = noDA;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "noDA=" + noDA +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) { //Dois être définit avec les HashMap et HashSet...
        if (object == null || getClass() != object.getClass()) return false;

        Etudiant etudiant = (Etudiant) object;
        return noDA == etudiant.noDA;
    }

//    @Override
//    public int hashCode() { //Dois être définit avec les HashMap et HashSet...
//        return noDA; //on est certain qu'il n'y aira jamais 2 hash pareil pour 2 DA différents
//    }

    @Override
    public int hashCode() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    @Override //Dois être définit avec les TreeMap et TreeSet...
    public int compareTo(Etudiant etudiant) {
        return Integer.compare(this.noDA, etudiant.noDA);
    }
}
