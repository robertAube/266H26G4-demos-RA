package solutionsFormatifs.Formatif1_sol.animaux;

public class Crocodile {
    //constantes
    private static final double EPSILON = 0.0000001;
    public final static int NOMBRE_DE_DENTS_DEFAUT = 100;
    public final static int NOMBRE_DE_DENTS_MIN = 0;
    public final static int NOMBRE_DE_DENTS_MAX = 200;
    private static final int TAILLE_DENT_MAX = 10;
    private static final int TAILLE_DENT_MIN = 1;
    public final static String ESPECE_DEFAUT = "Crocodile";
    public final static double TAILLE_MIN = 1;
    public final static double TAILLE_MAX = 5;
    public final static int TAILLE_DEFAUT = 1;
    public final static int NOMBRE_REPAS_DEFAUT = 0;
    public final static double SEUIL_DE_VICTOIRE = 19.999999;
    private static final double FACTEUR_GAIN_TAILLE = 0.3;

    //attributs
    private int nombreDeDents;
    private String espece;
    private double taille;
    private int nombreDeRepas;

    public long getIdentifiant() {
        return identifiant;
    }

    private long identifiant;
    private static long dernierCrocodile = 0;
    private int[] dents;

    public void setNombreDeDents(int nombreDeDents) {
        this.nombreDeDents = nombreDeDents;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public int getNombreDeDents() {
        return nombreDeDents;
    }

    public String getEspece() {
        return espece;
    }

    public double getTaille() {
        return taille;
    }

    public int getNombreDeRepas() {
        return nombreDeRepas;
    }

    public Crocodile() {
        this(NOMBRE_DE_DENTS_DEFAUT, TAILLE_DEFAUT);
        this.espece = ESPECE_DEFAUT;
        this.nombreDeRepas = NOMBRE_REPAS_DEFAUT;
    }


    public Crocodile(int nombreDeDents, double taille) {
        this.nombreDeDents = nombreDeDents;
        this.espece = ESPECE_DEFAUT;
        this.taille = taille;
        this.nombreDeRepas = NOMBRE_REPAS_DEFAUT;
        this.identifiant = dernierCrocodile++;
        assert valideNombreDents(nombreDeDents) : "mauvais nombre de dents";
        assert valideTaille(taille) : "mauvaise taille";

        this.dents = new int[NOMBRE_DE_DENTS_MAX];
        this.creeDentier();
    }

    public int[] getDents() {
        return dents.clone();// clone pour avoir une copie et ainsi éviter que
        // le client ne perturbe les données internes
    }

    @Override
    public String toString() {
        return "Crocodile [nombreDeDents=" + nombreDeDents + ", espece=" + espece + "_" + identifiant + ", taille="
                + taille + ", nombreDeRepas=" + nombreDeRepas + "]";
    }

    /**
     * Crée le dentier du crocodile. Les dents sont au centre de la gueule.
     */
    private void creeDentier() {
        int decalage = (NOMBRE_DE_DENTS_MAX - nombreDeDents) / 2;

        for (int i = decalage; i < (nombreDeDents + decalage); i++) {
            dents[i] = (int) (TAILLE_DENT_MIN + Math.random() * (TAILLE_DENT_MAX - TAILLE_DENT_MIN));
        }
    }

    /**
     * Crée le dentier du crocodile. Les dents sont symétriques.
     * Les dents sont au centre de la gueule.
     */
    public void creeDentierDefi() {
        int decalage = (NOMBRE_DE_DENTS_MAX - nombreDeDents) / 2;
        int tailleMax = 0;

        // on crée les dents
        for (int i = decalage; i < ((nombreDeDents / 2) + decalage); i++) {
            // la taille est aléatoire.
            int nouvelleTaille = (int) (TAILLE_DENT_MIN + Math.random() * (TAILLE_DENT_MAX - TAILLE_DENT_MIN));

            // les dents sont symétriques.
            dents[i] = nouvelleTaille;
            dents[NOMBRE_DE_DENTS_MAX - i - 1] = nouvelleTaille;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crocodile crocodile = (Crocodile) o;
        return nombreDeDents == crocodile.nombreDeDents &&
                Double.compare(crocodile.taille, taille) == 0 &&
                nombreDeRepas == crocodile.nombreDeRepas &&
                espece.equals(crocodile.espece);

    }

    public static boolean valideTaille(double ptaille) {

        return ptaille >= TAILLE_MIN && ptaille <= TAILLE_MAX;
    }

    public static boolean valideNombreDents(int nombreDeDents) {
        return nombreDeDents >= NOMBRE_DE_DENTS_MIN && nombreDeDents <= NOMBRE_DE_DENTS_MAX;
    }

    public static void reinitialiseCompteur() {
        dernierCrocodile = 0;
    }

    /**
     * Fait combattre 2 crocodiles. Celui dont le nombre de dents multiplié par la
     * taille est le plus grand l'emporte si la différence est supérieure à un
     * seuil de victoire. Le vainqueur voit sa taille augmentée de la taille de
     * son adversaire multipliée par un certain facteur FACTEUR_GAIN_TAILLE. Le repas est finalement
     * comptabilisé.
     *
     * @param opposant le crocodile qui affronte ce crocodile
     * @return le perdant du combat (il est considéré mort) ou null si le combat n'a pas lieu.
     */
    //Crocodile perdant = premier.combattre(second);
    public Crocodile combattre(Crocodile opposant) {
        assert !opposant.equals(this) : "Se combat lui-même";
        assert opposant != null : "null param";

        double forcePremier = this.nombreDeDents * this.taille;
        double forceSecond = opposant.nombreDeDents * opposant.taille;

        Crocodile perdant = null;
        Crocodile gagnant = null;

        if (Math.abs(forcePremier - forceSecond) > SEUIL_DE_VICTOIRE) {
            perdant = opposant;
            gagnant = this;
        } else if (Math.abs(forceSecond - forcePremier) > SEUIL_DE_VICTOIRE) {
            // Le second l'emporte
            perdant = this;
            gagnant = opposant;
        }

        if (perdant != null && gagnant != null) {
            gagnant.taille += perdant.taille * FACTEUR_GAIN_TAILLE;
            gagnant.nombreDeRepas++;
        }
        return perdant;

    }
}

