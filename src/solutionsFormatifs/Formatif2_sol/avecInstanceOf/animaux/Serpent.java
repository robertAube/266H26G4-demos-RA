package solutionsFormatifs.Formatif2_sol.avecInstanceOf.animaux;

import static solutionsFormatifs.Formatif2_sol.avecInstanceOf.animaux.Crocodile.AJUSTEMENT_SERPENT;

public class Serpent {
    //constantes
    public static final String SERPENT = "Serpent";
    public final static double TAILLE_DEFAUT = 1;
    public final static double TAILLE_MIN = 1;
    public final static double TAILLE_MAX = 5;

    public final static double LONGUEUR_DEFAUT = 1;
    public final static double LONGUEUR_MIN = 0.5;
    public final static double LONGUEUR_MAX = 10;

    public final static int NOMBRE_REPAS_DEFAUT = 0;

    public double SEUIL_DE_VICTOIRE = 20;
    private static final double FACTEUR_GAIN_TAILLE = 0.3;

    //attributs
    private String espece;
    private double taille;
    private double longueur;
    private int nombreDeRepas;

    public Serpent() {
        this(LONGUEUR_DEFAUT, TAILLE_DEFAUT);
        this.nombreDeRepas = NOMBRE_REPAS_DEFAUT;
    }

    /**
     * Construit un serpent
     *
     * @param longueur la longueur (compris entre 1 et 10)
     * @param taille   la taille du serpent (comprise entre 1 et 5)
     */
    public Serpent(double longueur,  double taille) {
        //super();

        assert taille > TAILLE_MIN : "taille négative";
        assert taille < TAILLE_MAX : "taille supérieure à " + TAILLE_MAX;
        assert longueur > LONGUEUR_MIN : "trop court";
        assert longueur < LONGUEUR_MAX : "trop long";

        this.espece = SERPENT;
        this.taille = taille;
        this.longueur = longueur;
        this.nombreDeRepas = NOMBRE_REPAS_DEFAUT;
    }

    public String getEspece() {

        return espece;
    }

    public void setEspece(String espece) {
        assert espece != null : "espece null";
        this.espece = espece;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        assert taille > 0 : "taille inférieur à 0";
        this.taille = taille;
    }

    public int getNombreDeRepas() {
        return nombreDeRepas;
    }

    public void setNombreDeRepas(int nombreDeRepas) {
        this.nombreDeRepas = nombreDeRepas;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        assert longueur > LONGUEUR_MIN : "trop court";
        assert longueur < LONGUEUR_MAX : "trop long";

        this.longueur = longueur;
    }

    @Override
    public String toString() {
        return "Serpent espece=" + espece + ", taille=" + Math.round(taille * 100.0) / 100.0 +", Longueur"+ Math.round(longueur* 100.0) / 100.0+ "]";
    }


    /**
     * Fait combattre 2 serpents. Celui dont la longueur multipliée par la taille
     * est le plus grand l'emporte si la différence est supérieure à un seuil de
     * victoire. Le vainqueur voit sa taille augmentée de la taille de son
     * adversaire multipliée par un certain facteur. Le repas est finalement
     * comptabilisé.
     *
     * @param opposant le crocodile qui affronte ce crocodile
     * @return le perdant du combat (il est considéré mort)
     */
    public Serpent combattre(Serpent opposant) {
        Serpent perdant = null;
        double forcePremier = longueur * taille;
        double forceSecond = opposant.longueur * opposant.taille;

        if (forcePremier - forceSecond > SEUIL_DE_VICTOIRE) {
            // le premier l'emporte
            this.taille += opposant.taille * FACTEUR_GAIN_TAILLE;
            this.nombreDeRepas++;
            perdant = opposant;
        } else {
            // Le second l'emporte
            opposant.taille += this.taille * FACTEUR_GAIN_TAILLE;
            opposant.nombreDeRepas++;
            perdant = this;
        }
        return perdant;
    }


    /**
     * Fait combattre un serpent à un crocodile.      *
     * @param opposant le crocodile qui affronte ce crocodile
     * @return le perdant du combat (il est considéré mort)
     */
    public Object combattre(Crocodile opposant) {
        Object perdant = null;
        double forcePremier = longueur * taille * AJUSTEMENT_SERPENT;
        double forceSecond = opposant.getNombreDeDents() * opposant.getTaille();

        if (forcePremier - forceSecond > SEUIL_DE_VICTOIRE) {
            // le premier l'emporte
            this.taille += opposant.getNombreDeDents() * FACTEUR_GAIN_TAILLE;
            this.nombreDeRepas++;
            perdant = opposant;
        } else if (forceSecond-forcePremier > SEUIL_DE_VICTOIRE) {
            // Le second l'emporte
            opposant.setTaille(opposant.getTaille()+ this.taille * FACTEUR_GAIN_TAILLE);
            opposant.setNombreDeRepas(opposant.getNombreDeRepas()+1);
            perdant = this;
        }
        return perdant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Serpent other = (Serpent) obj;
        if (espece == null) {
            if (other.espece != null)
                return false;
        } else if (!espece.equals(other.espece))
            return false;
        if (Double.doubleToLongBits(longueur) != Double.doubleToLongBits(other.longueur))
            return false;
        if (nombreDeRepas != other.nombreDeRepas)
            return false;
        if (Double.doubleToLongBits(taille) != Double.doubleToLongBits(other.taille))
            return false;
        return true;
    }



}
