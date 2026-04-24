package solutionsFormatifs.Formatif4_sol.Formatif4_P1;

/**
 * Formatif-4: 266-LI : Matrices
 */
public class Corrige_Formatif4 {

    /**
     * 1. Écrire une méthode qui place des 1 sur la première ligne d'une
     * matrice, des 2 sur la deuxième, des 3 sur la troisième, etc…
     *
     * <pre>
     *                          ----------------------
     *                         |                      |
     *               mat --->  |     placerMat123     |---> mat
     *                         |                      |
     *                          ----------------------
     *   	placerMat123(mat)
     *         Pour i variant de 0 à nbLignes-1
     *             Pour j variant de 0 à nbColonnes-1
     *                 mat[i][j] = i+1
     *             Fin pour
     *         Fin pour
     * </pre>
     *
     * @param mat, une matrice d'entiers
     */
    public static void placerMat123(int[][] mat) {
        // Boucle pour les lignes
        for (int i = 0; i < mat.length; i++) {
            // Boucle pour les colonnes
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = i + 1;
            }
        }
    }

    /**
     * 2. Écrire une méthode qui retourne une matrice de n lignes et n colonnes
     * où il y aura des 1 sur la première ligne, des 2 sur la deuxième, etc…
     *
     * <pre>
     *                          ----------------------
     *                         |                      |
     *                 n --->  |   genererMat123      |---> mat
     *                         |                      |
     *                          ----------------------
     *   Algo: genererMat123
     *         Créer une matrice mat de n par n
     *         Pour i variant de 0 à n-1
     *             Pour j variant de 0 à n-1
     *                 mat[i][j] = i+1
     *             Fin pour
     *         Fin pour
     *         retourner mat
     * </pre>
     *
     * @param n, les dimensions de la matrice
     * @return un tableau D2 de int
     */
    public static int[][] genererMat123(int n) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = i + 1;
            }
        }

        return mat;
    }

    /**************************************************************************
     * 3. Écrire une méthode qui retourne la somme des éléments d'une matrice.
     *
     * <pre>
     *                          ----------------------
     *                         |                      |
     *               mat --->  |    calculerSomme     |---> somme
     *                         |                      |
     *                          ----------------------
     *   Algo: calculerSomme (mat)
     *         somme = 0
     *         Pour i variant de 0 à nbLignes-1
     *             Pour j variant de 0 à nbColonnes-1
     *                 somme = somme + mat[i][j]
     *             Fin pour
     *         Fin pour
     *         retourner somme
     * </pre>
     *
     * @param mat, une matrice
     *
     * @return int, la somme des valeurs dans la matrice
     */
    public static int calculerSomme(int[][] mat) {
        int somme = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                somme += mat[i][j];
            }
        }

        return somme;
    }

    /**
     * 4. Écrire une méthode , qui retourne vrai si les éléments d'un vecteur
     * sont égaux, valeur pour valeur, aux éléments d'une des lignes d'une
     * matrice et faux sinon. Si le vecteur n'a pas le même nombre d'éléments
     * qu'une ligne de la matrice, retourner faux.
     *
     * <pre>
     *                          ----------------------
     *                         |                      |
     *              vect --->  |   chercherVecteur    |---> vrai ou faux
     *              mat --->   |                      |
     *                          ----------------------
     *   Algo: chercherVecteur (vect, mat)
     *         ok = vrai
     *         Si longueur de vect <> de nbColonnes
     *             ok = faux
     *         Sinon
     *             Pour i variant de 0 à nbLignes-1
     *                 ok = vrai
     *                 Pour j variant de 0 à nbColonnes-1
     *                     Si mat[i][j]<> vect[j]
     *                         ok = faux
     *                     Fin si
     *                 Fin pour
     *                 Si ok = vrai
     *                     i = nbLignes // pour sortir de la méthode
     *                 Fin si
     *             Fin pour
     *         Fin si
     *         retourner ok
     * </pre>
     *
     * @param vect, un vecteur d'entiers
     * @param mat,  une matrice d'entiers
     * @return boolean, vrai si les valeurs d'une des lignes de la matrice est
     * égale aux valeurs du vecteur, faux sinon
     */
    public static boolean chercherVecteur(int[] vect, int[][] mat) {
        boolean ok = true;

        // Vérifier si la taille des deux structures de données concorde
        if (vect.length != mat[0].length) {
            ok = false;
        } else {
            // Boucle des lignes
            for (int i = 0; i < mat.length; i++) {
                ok = true;

                // Boucle des colonnes
                for (int j = 0; (j < mat[0].length); j++) {
                    if (mat[i][j] != vect[j]) {
                        ok = false;
                    }
                }

                // Si tous les nombres d'une ligne sont égaux à
                // ceux du vecteur, sortir de la méthode
                if (ok) {
                    i = mat.length;
                }
            }
        }

        return ok;
    }

    /**
     * Idem la question no 4 précédente
     *
     * @param vect, un vecteur d'entiers
     * @param mat,  une matrice d'entiers
     * @return boolean, vrai si les valeurs d'une des lignes de la matrice est
     * égale aux valeurs du vecteur, faux sinon
     */
    public static boolean chercherVecteurWhile(int[] vect, int[][] mat) {
        boolean ok = true;
        // Déclaration des compteurs de lignes et de colonnes
        int i = 0, j = 0;

        // Vérifier si la taille des deux structures de données concorde
        if (vect.length != mat[0].length) {
            ok = false;
        } else {
            // Boucle des lignes
            while (i < mat.length) {
                ok = true;
                j = 0;

                // Boucle des colonnes
                while (ok && (j < mat[0].length)) {
                    if (mat[i][j] != vect[j]) {
                        ok = false;
                    }

                    j++;
                }

                // Si tous les nombres d'une lignes sont égaux à
                // ceux du vecteur, sortir de la boucle
                if (ok) {
                    i = mat.length;
                }

                i++;
            }
        }

        return ok;
    }

    /**
     * 5. Écrire une méthode qui retourne vrai si une matrice est carrée et faux
     * sinon. Une matrice est carrée si elle a le même nombre de lignes et de
     * colonnes.
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *               mat --->  |    verifierCarree    |---> vrai ou faux
     *                         |                      |
     *                          ----------------------
     *   Algo: verifierCarree (mat)
     *   	   ok = faux
     *
     *         Si nbLignes = nbColonnes
     *             ok = true
     *         Fin si
     *
     *         retourner ok
     * </pre>
     *
     * @param mat une matrice d'entier, la matrice à vérifier.
     * @return boolean, vrai si la matrice est carrée et faux sinon.
     */
    public static boolean verifierCarree(int[][] mat) {
        return (mat.length == mat[0].length);
    }

    /**
     * 6. Écrire une méthode qui retourne une matrice identité de dimension n.
     * Une matrice identité est une matrice carrée où il y a des 1 sur la
     * diagonale principale et des 0 partout ailleurs.
     *
     * <pre>
     * 						    ----------------------
     *                         |                      |
     *                 n --->  |   genererIdentite    |---> mat
     *                         |                      |
     *                          ----------------------
     *   Algo: genererIdentite (n)
     *             créer une matrice mat de dimension n par n
     *             pour i variant de 0 à n-1
     *                 pour j variant de 0 à n-1
     *                     si i = j
     *                         mat[i][j]=1
     *                     sinon
     *                         mat[i][j]=0
     *                 fin pour
     *             Fin pour
     *             retourner mat
     * </pre>
     *
     * @param n un entier la dimension de la matrice
     * @return int[][] la matrice identité
     */
    public static int[][] genererIdentite(int n) {
        int[][] mat = new int[n][n];

        // Lignes
        for (int i = 0; i < n; i++) {
            // Colonnes
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = 0;
                }
            }
        }

        return mat;
    }

    /**
     * 7. Écrire une méthode qui retourne vrai si toutes les lignes d'une
     * matrice sont identiques et faux sinon.
     *
     * <pre>
     * 						    -------------------------
     *                         |                         |
     *                mat ---> |verifierLignesIdentiques |---> vrai ou faux
     *                         |                         |
     *                          -------------------------
     *   Algo: verifierLignesIdentiques (mat)
     *         ok = true
     *         Pour j variant de 0 à nbColonnes-1
     *             Pour i variant de 1 à nbLignes-1
     *                 Si mat[i][j]&lt;&gt; mat[0][j]
     *                     ok = faux     // et sortir de la méthode
     *                     i = nbLignes
     *                     j = nbColonnes
     *                 Fin si
     *             Fin pour
     *         Fin pour
     *         retourner ok
     * </pre>
     * <p>
     * Nom : vérifierLignesIdentiques Entrées : mat, la matrice Sorties : aucune
     * Retour : vrai ou faux But: vérifier si toutes les lignes sont identiques
     *
     * @param mat une matrice d'entiers
     * @return boolean, vrai si toutes les lignes de la matrice sont identiques,
     * faux sinon
     */
    public static boolean verifierLignesIdentiques(int[][] mat) {
        boolean ok = true;

        // Boucle pour les lignes
        for (int j = 0; j < mat[0].length && ok; j++) {
            // Boucle pour les colonnes
            for (int i = 1; i < mat.length && ok; i++) {
                // Prendre comme toujours référence la première ligne, soit
                // mat[0]...
                if (mat[i][j] != mat[0][j]) {
                    ok = false;
                }
            }
        }

        return ok;
    }

    /**
     * 8. Écrire une méthode qui retourne vrai si les éléments des coins d'une
     * matrice sont tous égaux et faux sinon.
     *
     * <pre>
     * 							-----------------------
     *                         |                       |
     *               mat --->  |verifierCoinsIdentiques|---> vrai ou faux
     *                         |                       |
     *                          -----------------------
     *   Algo: verifierCoinsIdentiques
     *         retourner   mat[0][0] = mat[0][nbColonnes-1] et
     *                     mat[0][0] = mat[nbLignes-1][0]   et
     *                     mat[0][0] = mat[nbLignes-1][nbColonnes-1]
     * </pre>
     * <p>
     * Nom : verifierCoinsIdentiques Entrées : mat, une matrice Sorties : aucune
     * Retour : vrai ou faux But: Vérifie si les 4 coins d'une matrice sont
     * identiques
     *
     * @param mat une matrice d'entier
     * @return boolean, vrai si les coin sont égaux, faux sinon
     */
    public static boolean verifierCoinsIdentiques(int[][] mat) {
        int nbLignes = mat.length;
        int nbColonnes = mat[0].length;

        return (mat[0][0] == mat[0][nbColonnes - 1])
                && (mat[0][0] == mat[nbLignes - 1][0])
                && (mat[0][0] == mat[nbLignes - 1][nbColonnes - 1]);
    }

    /**
     * 9. Écrire une méthode qui remplacera toutes les valeurs supérieures à 10
     * dans une matrice par la valeur 10.
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *               mat --->  |    maximiserA10      |---> mat
     *                         |                      |
     *                          ----------------------
     *   Algo: maximiserA10 (mat)
     *         Pour i variant de 0 à nbLignes-1
     *             Pour j variant de 0 à nbColonnes-1
     *                 Si mat[i][j]&gt;10
     *                     mat[i][j]=10
     *                 Fin si
     *             Fin pour
     *         Fin pour
     * </pre>
     *
     * @param mat une matrice d'entier.
     */
    public static void maximiserA10(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > 10) {
                    mat[i][j] = 10;
                }
            }
        }
    }

    /**
     * 10. Écrire une méthode, qui retourne vrai si les éléments d'une des
     * diagonales d'une matrice carrée sont tous égaux entre eux et faux sinon.
     * Si la matrice n'est pas carrée, retourner faux
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *               mat --->  | verifierUneDiagonale |---> vrai ou faux
     *                         |                      |
     *                          ----------------------
     *   Algo: verifierUneDiagonale (mat)
     *         Si nbLignes = nbColonnes
     *             ok = vrai
     *         sinon
     *             ok = faux
     *         fin si
     *         Si ok=vrai // la matrice est carrée
     *             // vérifier la diagonale principale
     *             Pour i variant de 1 à nbLignes-1
     *                 Si mat[i][i]&lt;&gt;mat[0][0]
     *                     ok = faux
     *                 Fin si
     *             Fin pour
     *             Si ok = faux // ça ne marche pas pour la diagonale principale
     *                 // vérifier l'autre diagonale
     *                 ok = vrai
     *                 Pour i variant de 1 à nbLignes-1
     *                     Si mat[i][nbColonnes-1-i]&lt;&gt;mat[0][nbColonnes-1]
     *                         ok = faux
     *                     Fin si
     *                 Fin pour
     *             Fin si
     *         Fin si
     *         retourner ok
     * </pre>
     *
     * @param mat un matrice d'entier
     * @return boolean, vrai si les éléments d'une des diagonales sont tous
     * égaux entre eux, faux sinon.
     */
    public static boolean verifierUneDiagonale(int[][] mat) {
        int nbLignes = mat.length;
        int nbColonnes = mat[0].length;

        // Utiliser la méthode déjà écrite
        boolean ok = (nbLignes == nbColonnes);

        // Si la matrice est carrée
        if (ok) {
            // Vérifier la première diagonale
            for (int i = 0; i < nbLignes && ok; i++) {
                if (mat[i][i] != mat[0][0]) {
                    ok = false;
                }
            }

            // Si la première diagonale n'est pas ok
            if (!ok) {
                // Vérifier la deuxième diagonale
                ok = true;

                for (int i = 0; i < nbLignes && ok; i++) {
                    if (mat[i][nbColonnes - 1 - i] != mat[0][nbColonnes - 1]) {
                        ok = false;
                    }
                }
            }
        }

        return ok;
    }

    /**
     * 11. Écrire une méthode qui retourne vrai si les éléments des diagonales
     * d'une matrice carrée sont égaux valeur pour valeur pour une même ligne et
     * faux sinon. Si la matrice n'est pas carre, retourner faux.  
     *
     * <pre>
     * 							--------------------------
     *                         |                          |
     *               mat --->  | verifierLignesDiagonales |---> vrai ou faux
     *                         |                          |
     *                          --------------------------
     *   Algo: verifierLignesDiagonales (mat)
     *         Si nbLignes = nbColonnes
     *             ok = vrai
     *         Sinon
     *             ok = faux
     *         Fin si
     *
     *         Si ok=vrai // la matrice est carrée
     *             Pour i variant de 0 à nbLignes-1
     *                 Si mat[i][i] != mat[i][nbColonnes-1-i]
     *                     ok = faux
     *                 Fin si
     *             Fin pour
     *         Fin si
     *         retourner ok
     * </pre>
     *
     * @param mat une matrice d'entier
     * @return boolean vrai si les éléments de la diagonale sont égaux, faux
     * sinon
     */
    public static boolean verifierLignesDiagonales(int[][] mat) {
        int nbLignes = mat.length;
        int nbColonnes = mat[0].length;
        boolean ok = (nbLignes == nbColonnes);

        if (ok) {
            for (int i = 0; ((i < nbLignes) && ok); i++) {
                if (mat[i][i] != mat[i][nbColonnes - 1 - i]) {
                    ok = false;
                }
            }
        }

        return ok;
    }

    /**
     * 12. Écrire une méthode qui retourne un vecteur des sommes des lignes
     * d'une matrice.
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *               mat --->  |     sommerLignes     |---> vect
     *                         |                      |
     *                          ----------------------
     *   Algo: sommerLignes (mat)
     *         créer un vecteur vect de dimension nbLignes
     *
     *         Pour i variant de 0 à nbLignes-1
     *             vect[i]= 0
     *             Pour j variant de 0 à nbColonnes-1
     *                 vect[i] = vect[i] + mat[i][j]
     *             Fin pour
     *         Fin pour
     *
     *         retourner vect
     * </pre>
     *
     * @param mat une matrice d'entier
     * @return int[] un vecteur d'entier la somme de chaque ligne
     */
    public static int[] sommerLignes(int[][] mat) {
        int[] vect = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            vect[i] = 0;

            for (int j = 0; j < mat[0].length; j++) {
                vect[i] += mat[i][j];
            }
        }

        return vect;
    }

    /**
     * 13. Écrire une méthode qui retourne une matrice où on aura enlevé la
     * première ligne et la dernière colonne d'une matrice fournie en entrée.
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *              mat1 --->  |     reduireMat       |---> mat2
     *                         |                      |
     *                          ----------------------
     *   Algo: reduireMat (mat1)
     *         créer un matrice mat2 de nbLignes-1 par nbColonnes-1
     *
     *         Pour i variant de 1 à nbLignes-1
     *             Pour j variant de 0 à nbColonnes-2
     *                 mat2[i-1][j] = mat[i][j]
     *             Fin pour
     *         Fin pour
     *
     *         retourner mat2
     * </pre>
     *
     * @param mat1 une matrice d'entier
     * @return int[][]une matrice où on aura enlevé la première ligne et la
     * dernière colonne
     */
    public static int[][] reduireMat(int[][] mat1) {
        int[][] mat2 = new int[mat1.length - 1][mat1[0].length - 1];

        for (int i = 1; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length - 1; j++) {
                mat2[i - 1][j] = mat1[i][j];
            }
        }

        return mat2;
    }

    /**
     * 14. Écrire une méthode qui retournera une matrice où on aura ajouté une
     * colonne à une matrice fournie en entrée. Cette colonne contiendra les
     * sommes de chacune des lignes.
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *              mat1 --->  |  ajouterColonneSomme |---> mat2
     *                         |                      |
     *                          ----------------------
     *   Algo: ajouterColonneSomme (mat1)
     *         créer un matrice mat2 de nbLignes par nbColonnes+1
     *         Pour i variant de 0 à nbLignes-1
     *             mat2[i][nbColonnes]=0
     *             Pour j variant de 0 à nbColonnes-2
     *                 mat2[i][j]= mat1[i][j]
     *                 mat2[i][nbColonnes]=mat2[i][nbColonnes]+mat1[i][j]
     *             Fin pour
     *         Fin pour
     *         retourner mat2
     * </pre>
     *
     * @param mat1 une matrice d'entier
     * @return int[][] une matrice où on aura ajoute une colonne avec la somme
     * de chaque ligne.
     */
    public static int[][] ajouterColonneSomme(int[][] mat1) {
        int nbColonnes = mat1[0].length;
        int[][] mat2 = new int[mat1.length][nbColonnes + 1];

        for (int i = 0; i < mat1.length; i++) {
            mat2[i][nbColonnes] = 0;

            for (int j = 0; j < nbColonnes; j++) {
                mat2[i][j] = mat1[i][j];
                mat2[i][nbColonnes] += mat1[i][j];
            }
        }

        return mat2;
    }


    /**
     * Méthode utilitaire qui affiche une matrice dans la fenêtre
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *               mat --->  |     afficherMat      |
     *                         |                      |
     *                          ----------------------
     *                                              |
     *                                    Les valeurs de la matrice
     *   Algo: afficherMat (mat)
     *         Pour i variant de 0 à nbLignes-1
     *             Pour j variant de 0 à nbColonnes-1
     *                 afficher mat[i][j] et une tabulation
     *             Fin pour
     *             changer de ligne
     *         Fin pour
     *         changer de ligne
     * </pre>
     *
     * @param mat, une matrice d'entiers
     */
    public static void afficherMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * Méthode utilitaire qui affiche un vecteur dans la fenêtre DOS
     *
     * <pre>
     * 							----------------------
     *                         |                      |
     *              vect --->  |     afficherVect     |
     *                         |                      |
     *                          ----------------------
     *                                              |
     *                                    Les valeurs du vecteur
     *   Algo: afficherVect (vect)
     *         Pour i variant de 0 à longueur de vect
     *             afficher vect[i] et une tabulation
     *         Fin pour
     *         changer de ligne
     * </pre>
     *
     * @param vect, un vecteur d'entiers
     */
    public static void afficherVect(int[] vect) {
        for (int i = 0; i < vect.length; i++) {
            System.out.print(vect[i] + "\t");
        }

        System.out.println();
    }

    /**
     * Point d'entré pour l'ensemble.
     *
     * @param arg
     */
    public static void main(String[] arg) {
        int[][] mat =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        int[] vect =
                {4, 3, 6};


        afficherMat(mat);
        afficherVect(vect);


    }
} // fin de la classe