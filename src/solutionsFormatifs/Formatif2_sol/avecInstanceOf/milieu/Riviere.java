package solutionsFormatifs.Formatif2_sol.avecInstanceOf.milieu;

import solutionsFormatifs.Formatif2_sol.avecInstanceOf.animaux.*;

public class Riviere {

    public final static int NOMBRE_ANIMAUX_MIN = 2;
    public final static int NOMBRE_ANIMAUX_MAX = 10;

    private Object[] animaux;


    //Retourne les animaux du tableau
    public void getAnimaux() { //TODO ne devrait pas faire d'affichage
        int j = 0;
        for (int i = 0; i < animaux.length; i++) {
            j = i + 1;
            System.out.println("Animal " + j + ": " + animaux[i]);
        }
    }

    public Riviere(int nombreAnimaux) {

        assert nombreAnimaux >= NOMBRE_ANIMAUX_MIN : "Nombre inférieur à " + NOMBRE_ANIMAUX_MIN;
        assert nombreAnimaux <= NOMBRE_ANIMAUX_MAX : "Nombre supérieur à " + NOMBRE_ANIMAUX_MAX;

        animaux = new Object[nombreAnimaux];

        for (int i = 0; i < nombreAnimaux; i++) {
            if (i % 2 == 0) { //un crocodile
                double taille = Crocodile.TAILLE_MIN + Math.random() * (Crocodile.TAILLE_MAX - Crocodile.TAILLE_MIN);
                int nombreDents = (int) (Crocodile.NOMBRE_DE_DENTS_MIN +
                        Math.random() * (Crocodile.NOMBRE_DE_DENTS_MAX - Crocodile.NOMBRE_DE_DENTS_MIN));
                animaux[i] = new Crocodile(nombreDents, taille);
            } else { //un serpent
                double taille = Crocodile.TAILLE_MIN + Math.random() * (Crocodile.TAILLE_MAX - Crocodile.TAILLE_MIN);
                double longueur = Serpent.TAILLE_MIN + Math.random() * (Serpent.TAILLE_MAX - Serpent.TAILLE_MIN);
                animaux[i] = new Serpent(longueur, taille);
            }
        }
    }

    /**
     * Enlève un animal de la rivière. Il ne se passe rien si l'animal n'existe pas.
     *
     * @param animalAEffacer Le crocodile qu'on veut effacer
     */
    public void effaceAnimal(Object animalAEffacer) {
        for (int i = 0; i < animaux.length; i++) {
            if (animaux[i].equals(animalAEffacer)) {
                animaux[i] = null;// Ça crée des trous dans le tableaux de animaux... Il faut les gérer
            }
        }
    }

    /**
     * Retourne la position (indice +1) de l'animal recherché
     *
     * @param animalRecherche l'animal recherché.
     * @return la position de l'animal recherché.
     */
    public int trouveAnimal(Object animalRecherche) {
        int tr = -1;
        for (int i = 0; i < animaux.length; i++) {
            if (animaux[i].equals(animalRecherche)) {
                tr = i + 1;
            }
        }
        return tr;
    }

    /**
     * Confronte 2 crocodiles dont les indices sont reçus en paramètre. Le perdant est
     * retiré de la rivière.
     *
     * @param indicePremierAnimal l'indice du premier Animal à faire combattre
     * @param indiceSecondAnimal  l'indice du second Animal à faire combattre
     */
    public void combat(int indicePremierAnimal, int indiceSecondAnimal) {
        assert indicePremierAnimal > 0 : "premier Animal index négatif";
        assert indicePremierAnimal < animaux.length : "premier Animal hors du tableau";
        assert indiceSecondAnimal > 0 : "second Animal index négatif";
        assert indiceSecondAnimal < animaux.length : "second Animal hors du tableau";
        assert indicePremierAnimal != indiceSecondAnimal : "Animals identiques";

        Object premier = animaux[indicePremierAnimal];
        Object second = animaux[indiceSecondAnimal];
        System.out.println("Animal " + trouveAnimal(premier) + "  vs  " + trouveAnimal(second));
        // C'est ici que ça devient inutilement compliqué et propice aux erreurs!

        if (premier != null && second != null) { //le tableau statique peut contenir des null!
            Object perdant;
            if (premier instanceof Crocodile) {
                Crocodile premierCrocodile = (Crocodile) premier;
                if (second instanceof Crocodile) {
                    Crocodile secondCrocodile = (Crocodile) second;
                    perdant = premierCrocodile.combattre(secondCrocodile);
                } else {
                    Serpent secondSerpent = (Serpent) second;
                    perdant = premierCrocodile.combattre(secondSerpent);
                }
            } else {
                Serpent premierSerpent = (Serpent) premier;
                if (second instanceof Crocodile) {
                    Crocodile secondCrocodile = (Crocodile) second;
                    perdant = premierSerpent.combattre(secondCrocodile);
                } else {
                    Serpent secondSerpent = (Serpent) second;
                    perdant = premierSerpent.combattre(secondSerpent);
                }
            }
            System.out.println("Le perdant est: " + trouveAnimal(perdant));
            //On retire l'animal qui a perdu. Il ne doit plus servir car il a été mangé.
            effaceAnimal(perdant);
        }
    }

    /**
     * Fait combattre 2 animaux choisis au hasard.
     */
    public void combattre() {
        //On sélectionne 2 animaux et on les fait combattre
        int nombreanimaux = animaux.length;
        assert nombreanimaux > 1 : "un seul animal";

        int premierAnimal = (int) (Math.random() * nombreanimaux);
        int secondAnimal = premierAnimal;
        while (secondAnimal == premierAnimal || animaux[secondAnimal] == null) {
            secondAnimal = (int) (Math.random() * nombreanimaux);
        }
        combat(premierAnimal, secondAnimal);
    }
}
