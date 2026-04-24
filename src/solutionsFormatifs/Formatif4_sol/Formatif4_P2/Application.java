package solutionsFormatifs.Formatif4_sol.Formatif4_P2;

import static solutionsFormatifs.Formatif4_sol.Formatif4_P2.Jeu.*;
import static solutionsFormatifs.Formatif4_sol.Formatif4_P2.Utilitaires.Aleatoire.getNombreAleatoireEntreBorne;

public class Application {
    public static final int NB_PARTIE = 50;

    private Joueur j1 = new Joueur("Albert Rousseau", CAR_JOUEUR_1R);
    private Joueur j2 = new Joueur("Aya", CAR_JOUEUR_2B);

    public Application() {
        for (int nbPartie = 0; nbPartie < NB_PARTIE; nbPartie++) {
            faireUnePartie();
        }
    }

    private void faireUnePartie() {
        Jeu jeu = new Jeu();
        int noDeJoueurQuiJoueEnPremier = getNombreAleatoireEntreBorne(1, 2);

        jeu.jouer(j1, j2, noDeJoueurQuiJoueEnPremier);
        System.out.println(jeu);
    }

    public static void main(String[] args) {
        new Application();
    }
}