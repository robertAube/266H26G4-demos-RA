package solutionsFormatifs.Formatif3_sol.avecHeritage.animaux;

import java.util.Arrays;
import java.util.Objects;

public class Crocodile extends Animal {

    //constantes
    private static final double EPSILON = 0.0000001;
    private static final int TAILLE_DENT_MAX = 10;
    private static final int TAILLE_DENT_MIN = 1;
    public final static int NOMBRE_DE_DENTS_DEFAUT = 100;
    public final static int NOMBRE_DE_DENTS_MIN = 0;
    public final static int NOMBRE_DE_DENTS_MAX = 200;
    public final static String ESPECE_DEFAUT = "Crocodile";


    //attributs
    private int nombreDeDents;
    private String espece;
    private long identifiant;
    private static long dernierCrocodile = 0;
    private int[] dents;


    public Crocodile() {
        this(NOMBRE_DE_DENTS_DEFAUT, TAILLE_DEFAUT);
    }

    /**
     * Construit un crocodile
     *
     * @param nombreDeDents le nombre de dents (compris entre 0 et 200)
     * @param taille        la taille du crocodile(comprise entre 1 et 5)
     */
    public Crocodile(int nombreDeDents, double taille) {
        super(taille);
        assert taille - TAILLE_MIN > EPSILON : "taille négative";
        assert TAILLE_MAX - taille > EPSILON : "taille supérieure à " + TAILLE_MAX;
        assert valideNombreDents(nombreDeDents) : "mauvais nombre de dents";

        this.nombreDeDents = nombreDeDents;
        this.espece = ESPECE_DEFAUT;
        this.identifiant = dernierCrocodile++;
        this.dents = new int[NOMBRE_DE_DENTS_MAX];
        this.creeDentier();
    }

    public int getNombreDeDents() {
        return nombreDeDents;
    }

    public int[] getDents() {
        return dents.clone();// clone pour avoir une copie et ainsi éviter que
        // le client ne perturbe les données internes
    }

    public String getEspece() {
        return espece;
    }


    /**
     * Ajuste le nombre de dents du crocodile
     *
     * @param nombreDeDents Le nombre de dents.
     */
    public void setNombreDeDents(int nombreDeDents) {
        assert valideNombreDents(nombreDeDents) : "mauvais nombre de dents";
        this.nombreDeDents = nombreDeDents;
    }


    public static boolean valideNombreDents(int nombreDeDents) {
        return nombreDeDents > NOMBRE_DE_DENTS_MIN && nombreDeDents < NOMBRE_DE_DENTS_MAX;
    }

    /**
     * Crée le dentier du crocodile. les dents sont au centre de la gueule
     */
    private void creeDentier() {
        int decalage = (NOMBRE_DE_DENTS_MAX - nombreDeDents) / 2;

        for (int i = decalage; i < (nombreDeDents + decalage); i++) {
            dents[i] = (int) (TAILLE_DENT_MIN + Math.random() * (TAILLE_DENT_MAX - TAILLE_DENT_MIN));
        }
    }

    /**
     * Crée le dentier du crocodile Les dents sont symétriques les plus grosses
     * sont les 3e en partant du centre. Les dents sont au centre de la gueule.
     */
    public void creeDentierDefi() {
        int decalage = (NOMBRE_DE_DENTS_MAX - nombreDeDents) / 2;
        int tailleMax = 0;

        // on crée les dents
        for (int i = decalage; i < ((nombreDeDents / 2) + decalage); i++) {
            // la taille est aléatoire
            int nouvelleTaille = (int) (TAILLE_DENT_MIN + Math.random() * (TAILLE_DENT_MAX - TAILLE_DENT_MIN));

            // les dents sont symétriques
            dents[i] = nouvelleTaille;
            dents[NOMBRE_DE_DENTS_MAX - i - 1] = nouvelleTaille;

            // On doit connaître les dents les plus grande
            if (nouvelleTaille > tailleMax) {
                tailleMax = nouvelleTaille;
            }
        }

        // les 5e dents sont les plus grandes
        if (tailleMax < TAILLE_DENT_MAX) {
            tailleMax += 1;
        }
        dents[NOMBRE_DE_DENTS_MAX / 2 + 4] = tailleMax;
        dents[NOMBRE_DE_DENTS_MAX / 2 - 5] = tailleMax;

    }

    @Override
    public double getForce() {
        return nombreDeDents * getTaille();
    }

    public static void reinitialiseCompteur() {
        dernierCrocodile = 0;
    }

    @Override
    public String toString() {
        return "Crocodile{" +
                "nombreDeDents=" + nombreDeDents +
                ", espece='" + espece + '\'' +
                ", identifiant=" + identifiant +
                ", dents=" + Arrays.toString(dents) +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Crocodile crocodile = (Crocodile) o;

        if (nombreDeDents != crocodile.nombreDeDents) return false;
        if (identifiant != crocodile.identifiant) return false;
        if (espece != null ? !espece.equals(crocodile.espece) : crocodile.espece != null) return false;
        return Arrays.equals(dents, crocodile.dents);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + nombreDeDents;
        result = 31 * result + (espece != null ? espece.hashCode() : 0);
        result = 31 * result + (int) (identifiant ^ (identifiant >>> 32));
        result = 31 * result + Arrays.hashCode(dents);
        return result;
    }
}
