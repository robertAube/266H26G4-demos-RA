package solutionsFormatifs.Formatif3_sol.avecHeritage.animaux;

import java.util.Objects;

public abstract class Animal {

    private double taille;
    private int nombreDeRepas;

    public final static double SEUIL_DE_VICTOIRE = 19.999999;
    private static final double FACTEUR_GAIN_TAILLE = 0.3;
    public final static int NOMBRE_REPAS_DEFAUT = 0;
    public final static double TAILLE_DEFAUT = 1.01;
    public final static double TAILLE_MIN = 0.9999;
    public final static double TAILLE_MAX = 5.00001;

    public Animal(double taille) {
        assert taille > TAILLE_MIN : "taille négative";
        assert taille < TAILLE_MAX : "taille supérieure à " + TAILLE_MAX;

        this.taille = taille;
        this.nombreDeRepas = NOMBRE_REPAS_DEFAUT;
    }

    /**
     * Fait combattre 2 Animal. Celui dont la force
     * est le plus grand l'emporte si la différence est supérieure à un
     * seuil de victoire. Le vainqueur voit sa taille augmentée de la taille de
     * son adversaire multipliée par un certain facteur FACTEUR_GAIN_TAILLE. Le repas est finalement
     * comptabilisé.
     *
     * @param opposant AnimalI qui affronte
     * @return le perdant du combat (il est considéré mort) ou null si le combat n'a pas lieu.
     */
    public Animal combattre(Animal opposant) {
        //Maintenant une seule méthode vombattre est nécessaire et elle est la même pour le srpent et pour le crocodile!
        assert !opposant.equals(this) : "Se combat lui-même";
        assert opposant != null : "null param";

        double forcePremier = this.getForce();
        double forceSecond = opposant.getForce();

        Animal perdant = null;
        Animal gagnant = null;

        if (Math.abs(forcePremier - forceSecond) > SEUIL_DE_VICTOIRE) {
            if (forcePremier > forceSecond) {
                // le premier l'emporte
                perdant = opposant;
                gagnant = this;
            } else {
                // Le second l'emporte
                perdant = this;
                gagnant = opposant;
            }
            gagnant.setTaille(perdant.getTaille() * FACTEUR_GAIN_TAILLE);
            gagnant.ajouteRepas();
        }
        return perdant;
    }

    public int getNombreDeRepas() {
        return nombreDeRepas;
    }


    public void setNombreDeRepas(int nombreDeRepas) {
        assert nombreDeRepas >= 0 : "Nombre de repas négatif";

        this.nombreDeRepas = nombreDeRepas;
    }

    public void ajouteRepas() {
        nombreDeRepas++;
    }

    public abstract double getForce() ;

    public double getTaille() {
        return taille;
    }

    /**
     * Ajuste la taille de l'animal
     *
     * @param taille la taille doit être entre 1 et 5.
     */
    public void setTaille(double taille) {
        assert taille > TAILLE_MIN : "taille négative";
        assert taille < TAILLE_MAX : "taille supérieure à " + TAILLE_MAX;
        this.taille = taille;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "taille=" + taille +
                ", nombreDeRepas=" + nombreDeRepas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.taille, taille) == 0 &&
                nombreDeRepas == animal.nombreDeRepas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taille, nombreDeRepas);
    }
}
