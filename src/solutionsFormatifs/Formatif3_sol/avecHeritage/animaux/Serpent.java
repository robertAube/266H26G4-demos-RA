package solutionsFormatifs.Formatif3_sol.avecHeritage.animaux;


public class Serpent extends Animal {

    public static final String SERPENT = "Serpent";
    public static final int FACTEUR_AJUSTEMENT_SERPENT = 20;
    private String espece;
    private double longueur;

    public final static String NOM_DEFAUT = "crocodile";

    public final static double TAILLE_DEFAUT = 1;
    public final static double TAILLE_MIN = 1;
    public final static double TAILLE_MAX = 5;

    public final static double LONGUEUR_DEFAUT = 1;
    public final static double LONGUEUR_MIN = 0.5;
    public final static double LONGUEUR_MAX = 10;

    public final static int NOMBRE_REPAS_DEFAUT = 0;
    public final static double SEUIL_DE_VICTOIRE = 20;
    public final static double FACTEUR_GAIN_TAILLE = 0.3;
    public final static int AJUSTEMENT_SERPENT = 20;

    public Serpent() {
        this(LONGUEUR_DEFAUT, TAILLE_DEFAUT);
    }

    /**
     * Construit un serpent
     *
     * @param longueur la longueur (compris entre 1 et 10)
     * @param taille   la taille du serpent (comprise entre 1 et 5)
     */
    public Serpent(double longueur, double taille) {
        super(taille);

        assert longueur > LONGUEUR_MIN : "trop court";
        assert longueur < LONGUEUR_MAX : "trop long";

        this.espece = SERPENT;
        this.longueur = longueur;
    }

    public String getEspece() {

        return espece;
    }

    public void setEspece(String espece) {
        assert espece != null : "espece null";
        this.espece = espece;
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
    public double getForce() {
        return longueur * getTaille() * FACTEUR_AJUSTEMENT_SERPENT;
    }

    @Override
    public String toString() {
        return "Serpent{" +
                "espece='" + espece + '\'' +
                ", longueur=" + longueur +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Serpent serpent = (Serpent) o;

        if (Double.compare(serpent.longueur, longueur) != 0) return false;
        return espece != null ? espece.equals(serpent.espece) : serpent.espece == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (espece != null ? espece.hashCode() : 0);
        temp = Double.doubleToLongBits(longueur);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
