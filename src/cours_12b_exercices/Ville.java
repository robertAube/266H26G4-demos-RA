package cours_12b_exercices;

import java.util.Objects;

public class Ville implements Comparable<Ville> {
    private static final float POPULATION_DEFAUT = 0f; //0 on considère que c'est inconnu
    private String nom;
    private String pays;
    private float population; //en millions - si 0 on considère que c'est inconnu

    public Ville(String nom, String pays) {
        this(nom, pays, POPULATION_DEFAUT);
    }

    public Ville(String nom, String pays, float population) {
        this.nom = nom;
        this.pays = pays;
        this.population = population;
    }

    @Override
    //equals : 2 villes sont égales si leur nom et leur pays sont égaux
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Ville ville = (Ville) object;
        return nom.equals(ville.nom) && pays.equals(ville.pays);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nom);
        result = 31 * result + Objects.hashCode(pays);
        return result;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", population=" + (population == 0 ? "?" : population) +
                '}';
    }

    //Trier par pays puis par nom de villes
    @Override
    public int compareTo(Ville ville) {
        int compareValue;
        compareValue = pays.compareTo(ville.pays);
        if (compareValue == 0) {
            compareValue = nom.compareTo(ville.nom);
        }
        return compareValue;
    }
}
