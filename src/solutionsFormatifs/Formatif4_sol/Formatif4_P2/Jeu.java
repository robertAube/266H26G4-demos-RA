package solutionsFormatifs.Formatif4_sol.Formatif4_P2;

import solutionsFormatifs.Formatif4_sol.Formatif4_P2.Utilitaires.Couleurs;

import static solutionsFormatifs.Formatif4_sol.Formatif4_P2.Utilitaires.Aleatoire.getNombreAleatoireEntreBorne;

/**
 * Classe représentant un jeu TakeFive avec matrice 10x10 et caractère du joueur
 * courant (R ou B).
 *
 *
 */
public class Jeu {
    /**
     * Dimension de la grille de jeu DIMENSION X DIMENSION
     */
    public static final int DIMENSION = 10;

    /**
     * Nombre de cases identiques consécutives pour faire un gain
     */
    public static final int NB_POUR_GAIN = 5;

    /**
     * Caractère d'une case qui n'est pas choisie
     */
    public static final char CAR_NEUTRE = ' ';

    /**
     * Caractère associé au joueur 1 (R pour rouge)
     */
    public static final char CAR_JOUEUR_1R = 'R';

    /**
     * Caractère associé au joueur 2 (B pour bleu)
     */
    public static final char CAR_JOUEUR_2B = 'B';

    /**
     * Le caractère que doit prendre la case de la matrice lors d'un clic.
     * Change selon le joueur courant du jeu!
     */
    private char carCourant;

    /**
     * Un tableau 2D de caractères pour former la grille en mémoire
     */
    private char[][] matJeu = null;

    /**
     * Création d'un jeu avec sa matrice de caractères initialisée avec des
     * espaces partout et le caractère courant initialisé à espace.
     *
     */
    public Jeu() {
        matJeu = new char[DIMENSION][DIMENSION];
        initialiser();
    }

    /**
     * Méthode accessoire...
     * <p>
     * Permet de mettre un caractère désiré dans une des cases de la matrice.
     * Utilisé pour faire des tests unitaires.
     *
     * @param ligne   la ligne du caractère
     * @param colonne la colonne du caractère
     * @param car     le caractère désiré
     */
    private void assignerCase(int ligne, int colonne, char car) {
        matJeu[ligne][colonne] = car;
    }

    /**
     * Initialiser la matrice de caractères en mettant le caractère neutre
     * (espace) partout.
     */
    private void initialiser() {
        // Lignes
        for (int ligne = 0; ligne < matJeu.length; ligne++) {
            // Colonnes
            for (int colonne = 0; colonne < matJeu[ligne].length; colonne++) {
                matJeu[ligne][colonne] = CAR_NEUTRE;
            }
        }
    }

    /**
     * Vérifier si tous les éléments de la matrice sont différents du caractère neutre (Espace).
     *
     * @return boolean, vrai s'il n'y a plus d'une case disponible
     */
    private boolean verifierPleine() {
        boolean pleine = true;

        for (int ligne = 0; ligne < matJeu.length && pleine; ligne++) {
            for (int colonne = 0; colonne < matJeu[ligne].length && pleine; colonne++) {
                // On cherche une case avec un espace
                if (matJeu[ligne][colonne] == ' ') {
                    pleine = false;
                }
            }
        }
        return pleine;
    }

    /**
     * Vérifier s'il y a NB_POUR_GAIN cases ayant le même caractère que le
     * caractère courant sur une ligne horizontale à partir des indices ligne et colonne.
     * Est appelée par verifierGain()
     *
     * @param ligne   la ligne du bouton cliqué
     * @param colonne la colonne du bouton cliqué
     * @return boolean vrai si NB_POUR_GAIN cases de suite sur la même ligne ont
     * le même caractère que le caractère courant.
     */
    private boolean verifierCinqHorizontal(int ligne, int colonne) {
        int compteur = 1;
        char carCourant = matJeu[ligne][colonne];

        // Vers la droite
        int deltaCol = colonne + 1;
        while ((deltaCol < matJeu[ligne].length) && (matJeu[ligne][deltaCol] == carCourant)) {
            compteur++;
            deltaCol++;
        }

        // Vers la gauche
        deltaCol = colonne - 1;
        while ((deltaCol >= 0) && (matJeu[ligne][deltaCol] == carCourant)) {
            compteur++;
            deltaCol--;
        }

        if (compteur == NB_POUR_GAIN) {
            System.out.println("Dernier coup joué à la ligne: " + ligne + " et à la colonne: " + colonne);
            System.out.println("sortie de verifierCinqHorizontal, Compteur=" + compteur);
        }

        return (compteur == NB_POUR_GAIN);
    }

    /**
     * Vérifier s'il y a NB_POUR_GAIN cases ayant le même caractère que le
     * caractère courant sur une ligne verticale (colonne) à partir des indices
     * ligne et colonne. Est appelée par verifierGain()
     *
     * @param ligne   la ligne du bouton cliqué
     * @param colonne la colonne du bouton cliqué
     * @return boolean vrai si NB_POUR_GAIN cases de suite sur la même colonne
     * ont le même caractère que le caractère courant.
     */
    private boolean verifierCinqVertical(int ligne, int colonne) {
        int compteur = 1;
        char carCourant = matJeu[ligne][colonne];

        // Vers le bas
        int deltaLig = ligne + 1;
        while ((deltaLig < matJeu.length) && (matJeu[deltaLig][colonne] == carCourant)) {
            compteur++;
            deltaLig++;
        }

        // Vers le haut
        deltaLig = ligne - 1;
        while ((deltaLig >= 0) && (matJeu[deltaLig][colonne] == carCourant)) {
            compteur++;
            deltaLig--;
        }

        if (compteur == NB_POUR_GAIN) {
            System.out.println("Dernier coup joué à la ligne: " + ligne + " et à la colonne: " + colonne);
            System.out.println("sortie de verifierCinqVertical, Compteur=" + compteur);
        }
        return (compteur == NB_POUR_GAIN);
    }

    /**
     * Vérifier s'il y a NB_POUR_GAIN cases ayant le même caractère que le
     * caractère courant sur une diagonale gauche/droite à partir des indices ligne
     * et colonne. Est appelée par verifierGain()
     *
     * @param ligne   la ligne du bouton cliqué
     * @param colonne la colonne du bouton cliqué
     * @return boolean vrai si NB_POUR_GAIN cases de suite sur la même diagonale
     * gauche/droite ont le même caractère que le caractère courant.
     */
    private boolean verifierCinqDiagonaleGD(int ligne, int colonne) {
        int compteur = 1;
        char carCourant = matJeu[ligne][colonne];

        // Vers bas et droite
        int deltaLig = ligne + 1;
        int deltaCol = colonne + 1;

        while ((deltaLig < matJeu.length) && (deltaCol < matJeu[deltaLig].length)
                && (matJeu[deltaLig][deltaCol] == carCourant)) {
            compteur++;
            deltaLig++;
            deltaCol++;
        }

        // Vers haut et gauche
        deltaLig = ligne - 1;
        deltaCol = colonne - 1;

        while (deltaLig >= 0 && deltaCol >= 0 && matJeu[deltaLig][deltaCol] == carCourant) {
            compteur++;
            deltaLig--;
            deltaCol--;
        }
        if (compteur == NB_POUR_GAIN) {
            System.out.println("Dernier coup joué à la ligne: " + ligne + " et à la colonne: " + colonne);
            System.out.println("sortie de verifierCinqDiagonaleGD, Compteur=" + compteur);
        }
        return (compteur == NB_POUR_GAIN);
    }

    /**
     * Vérifier s'il y a NB_POUR_GAIN cases ayant le même caractère que le
     * caractère courant sur une diagonale droite/gauche à partir des indices ligne
     * et colonne. Est appelée par verifierGain()
     *
     * @param ligne   la ligne du bouton cliqué
     * @param colonne la colonne du bouton cliqué
     * @return boolean vrai si si NB_POUR_GAIN cases de suite sur la même
     * diagonale droite/gauche ont le même caractère que le caractère
     * courant.
     */
    private boolean verifierCinqDiagonaleDG(int ligne, int colonne) {
        int compteur = 1;
        char carCourant = matJeu[ligne][colonne];

        // Vers haut et droite
        int deltaLig = ligne - 1;
        int deltaCol = colonne + 1;
        while ((deltaLig >= 0) && (deltaCol < matJeu[deltaLig].length)
                && (matJeu[deltaLig][deltaCol] == carCourant)) {
            compteur++;
            deltaLig--;
            deltaCol++;
        }

        // Vers bas et gauche
        deltaLig = ligne + 1;
        deltaCol = colonne - 1;
        while ((deltaLig < matJeu.length) && (deltaCol >= 0)
                && (matJeu[deltaLig][deltaCol] == carCourant)) {
            compteur++;
            deltaLig++;
            deltaCol--;
        }
        if (compteur == NB_POUR_GAIN) {
            System.out.println("Dernier coup joué à la ligne: " + ligne + " et à la colonne: " + colonne);
            System.out.println("sortie de verifierCinqDiagonaleDG, Compteur=" + compteur);
        }
        return (compteur == NB_POUR_GAIN);
    }

    /**
     * Méthode qui fait l'ensemble des validations pour voir s'il y a un gain.
     * <p>
     * Vérifier s'il y a NB_POUR_GAIN cases ayant le même caractère que le
     * caractère courant dans les différentes directions : horizontale,
     * verticale et diagonale. Appelle les méthodes nécessaires pour faire le
     * travail.
     *
     * @param ligne   la ligne du bouton cliqué
     * @param colonne la colonne du bouton cliqué
     * @return boolean, vrai s'il a un gain
     */
    private boolean verifierGain(int ligne, int colonne) {
        boolean ilYAGain;
        ilYAGain = verifierCinqHorizontal(ligne, colonne);
        ilYAGain |= verifierCinqVertical(ligne, colonne); //Avec |= → toutes les méthodes sont appelées. Avec || → évaluation court-circuitée, s’arrête dès le premier true.
        ilYAGain |= verifierCinqDiagonaleGD(ligne, colonne);
        ilYAGain |= verifierCinqDiagonaleDG(ligne, colonne);

        return (ilYAGain);
    }

    /**
     * Retourne la matrice sous forme de dessin
     * <p>
     * Chaque case est représentée par [ ] avec à l'intérieur soit un espace,
     * soit un R soit un B Exemple pour une 3x3: [ ][R][B] [B][ ][R] [B][R][ ]
     *
     * @return String, dessin de la matrice
     */
    public String toString() {
        String chaine = "  ";

        for (int colonne = 0; colonne < matJeu.length; colonne++) { //entête de colonne
            chaine += " " + colonne + " ";
        }
        chaine += '\n';
        for (int ligne = 0; ligne < matJeu.length; ligne++) {
            chaine += ligne + " ";
            for (int colonne = 0; colonne < matJeu.length; colonne++) {
                chaine += getCaseCouleur(matJeu[ligne][colonne]);
            }

            chaine += "\n";
        }

        return chaine;
    }

    /**
     * Retourne une chaine d'une case de la bonne couleur en fonction du caractère de la case.
     * @param car le caractère de la case
     * @return chaine représentant une case de la bonne couleur
     */
    private String getCaseCouleur(char car) {
        String str = "[";
        switch (car) {
            case CAR_NEUTRE:
                str += ' ';
                break;
            case CAR_JOUEUR_1R:
                str += Couleurs.ROUGE + CAR_JOUEUR_1R + Couleurs.RESET;
                break;
            case CAR_JOUEUR_2B:
                str += Couleurs.BLEU + CAR_JOUEUR_2B + Couleurs.RESET;
                break;
        }
        return str + ']';
    }

    /**
     * Tant que la matrice n'est pas pleine, faites jouer deux joueurs et à tour de rôle, un avec le caractère R
     * et l’autre avec le caractère B.
     * L'assignation du caractère R ou B du joueur dans une case ligne, colonne est choisi au hasard
     * Le premier qui réussit à placer 5 caractères consécutifs en ligne, gagne la partie et l’exécution du programme s’arrête.
     * Pour cela, utilisez la méthode verifierGain(ligne, colonne)
     *
     * @param joueur1        le joueur 1
     * @param joueur2        le joueur 2
     * @param noJoueurAJouer indique à qui le tour. Si la valeur est 1, c'est au joueur 1 et le prochain tour sera au joueur 2.
     *                       Cette méthode est responsable de faire la gestion du numéro.
     */
    public void jouer(Joueur joueur1, Joueur joueur2, int noJoueurAJouer) {
        assert noJoueurAJouer != 1 && noJoueurAJouer != 2 : "no de joueur invalide: " + noJoueurAJouer;

        int ligne = getNombreAleatoireEntreBorne(0, DIMENSION - 1);
        int colonne = getNombreAleatoireEntreBorne(0, DIMENSION - 1);
        boolean ilYAUnGain;
        boolean matricePleine = false;
        do {
            while (matJeu[ligne][colonne] != ' ') { //trouver une case vide...
                ligne = getNombreAleatoireEntreBorne(0, DIMENSION - 1);
                colonne = getNombreAleatoireEntreBorne(0, DIMENSION - 1);
            }
            if (noJoueurAJouer == 1) {
                assignerCase(ligne, colonne, joueur1.getCouleur());
                noJoueurAJouer = 2;
            } else if (noJoueurAJouer == 2) {
                assignerCase(ligne, colonne, joueur2.getCouleur());
                noJoueurAJouer = 1;
            }

            ilYAUnGain = verifierGain(ligne, colonne);
            if (!ilYAUnGain)
                matricePleine = verifierPleine();
        } while (!matricePleine && !ilYAUnGain);
    }
}
