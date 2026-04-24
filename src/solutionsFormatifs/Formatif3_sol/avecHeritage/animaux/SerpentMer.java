package solutionsFormatifs.Formatif3_sol.avecHeritage.animaux;

public class SerpentMer extends Serpent {
    public static final int VITESSE_MIN = 1;
    public static final int VITESSE_MAX = 4;
    private float vitesse;

    public SerpentMer(double longueur, double taille, float vitesse) {
        super(longueur, taille);

        assert vitesse > VITESSE_MIN : "Vitesse insuffisante";
        assert vitesse < VITESSE_MAX : "Vitesse trop grande";

        this.vitesse = vitesse;
    }

    @Override
    public double getForce() {

        return super.getForce() * vitesse / 3.0;
    }
}
