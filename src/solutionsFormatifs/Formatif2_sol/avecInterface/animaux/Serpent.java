package solutionsFormatifs.Formatif2_sol.avecInterface.animaux;

public class Serpent implements Animal {
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
    public Serpent(double longueur, double taille) {
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
        String str;
        str = "Serpent espece=" + espece;
        str +=  ", taille=" + Math.round(taille * 100.0) / 100.0;
        str +=  ", Longueur" + Math.round(longueur * 100.0) / 100.0;

        return "Serpent espece=" + espece + ", taille=" + Math.round(taille * 100.0) / 100.0 + ", Longueur" + Math.round(longueur * 100.0) / 100.0 + "]";
    }

    /**
     * Fait combattre 2 Animal. Celui dont la force
     * est le plus grand l'emporte si la différence est supérieure à un
     * seuil de victoire. Le vainqueur voit sa taille augmentée de la taille de
     * son adversaire multipliée par un certain facteur FACTEUR_GAIN_TAILLE. Le repas est finalement
     * comptabilisé.
     *
     * @param opposant Animal qui affronte
     * @return le perdant du combat (il est considéré mort) ou null si le combat n'a pas lieu.
     */
    @Override
    public Animal combattre(Animal opposant) {
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
            } else if (forceSecond - forcePremier > SEUIL_DE_VICTOIRE) {
                // Le second l'emporte
                perdant = this;
                gagnant = opposant;
            }
            gagnant.setTaille(perdant.getTaille() * FACTEUR_GAIN_TAILLE);
            gagnant.ajouteRepas();
        }
        return perdant;
    }


    @Override
    public double getForce() {
        return taille * longueur * 20;
    }

    @Override
    public void ajouteRepas() {
        nombreDeRepas++;
    }

    @Override
    public double getTaille() {
        return taille;
    }

    @Override
    public void setTaille(double taille) {
        this.taille = taille;
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