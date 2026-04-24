package solutionsFormatifs.Formatif4_sol.Formatif4_P2.Utilitaires;
import java.util.concurrent.ThreadLocalRandom;

public class Aleatoire {


    /**
     * Génère un nombre aléatoire entre deux bornes inclusives.
     * Note: nécessite Java 17+
     * @param min valeur minimum incluse
     * @param max valeur maximum incluse
     * @return
     */
    public static int getNombreAleatoireEntreBorne(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
