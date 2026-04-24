package solutionsFormatifs.Formatif3_sol.avecHeritage.milieu;

import solutionsFormatifs.Formatif3_sol.avecHeritage.animaux.Animal;
import solutionsFormatifs.Formatif3_sol.avecHeritage.animaux.Crocodile;
import solutionsFormatifs.Formatif3_sol.avecHeritage.animaux.Serpent;


public class RiviereCrocodileTableauStatique {

    public final static int NOMBRE_CROCODILE_MIN = 2;
    public final static int NOMBRE_CROCODILE_MAX = 10;

    private Animal[] animaux;

    public RiviereCrocodileTableauStatique() {
        super();
        int nombreCrocodile = (int) (NOMBRE_CROCODILE_MIN
                + (Math.random() * NOMBRE_CROCODILE_MAX - NOMBRE_CROCODILE_MIN));

        animaux = new Crocodile[nombreCrocodile];

        for (int i = 0; i < nombreCrocodile; i++) {
            animaux[i] = new Crocodile();
        }
    }

    /**
     * Enlève un crocodile de la rivière. Il ne se passe rien si le crocodile n'existe pas.
     *
     * @param animalAEffacer Le crocodile qu'on veut effacer
     */
    public void effaceCrocodile(Animal animalAEffacer) {
        for (int i = 0; i < animaux.length; i++) {
            if (animaux[i].equals(animalAEffacer)) {
                animaux[i] = null;// Ça crée des trous dans le tableaux de crocodiles... Il faut les gérer
            }
        }
    }

    /**
     * Retourne tous les crocodiles qui sont supérieur à la taille demandée.
     *
     * @param crocodileRecherche le crocodile recherché.
     * @return le crocodile recherché.
     */
    public Object trouveCrocodile(Crocodile crocodileRecherche) {
        for (int i = 0; i < animaux.length; i++) {
            if (animaux[i].equals(crocodileRecherche)) {
                return animaux[i];
            }
        }
        return null;
    }

    /**
     * Confronte 2 crocodiles dont les indices sont reçus en paramètre. Le perdant est
     * retiré de la rivière.
     *
     * @param indicePremierCrocodile l'indice du premier Animal à faire combattre
     * @param indiceSecondCrocodile  l'indice du second Animal à faire combattre
     */
    public void combat(int indicePremierCrocodile, int indiceSecondCrocodile) {
        assert indicePremierCrocodile > 0 : "premier crocodile index négatif";
        assert indicePremierCrocodile < animaux.length : "premier crocodile hors du tableau";
        assert indiceSecondCrocodile > 0 : "second crocodile index négatif";
        assert indiceSecondCrocodile < animaux.length : "second crocodile hors du tableau";
        assert indicePremierCrocodile != indiceSecondCrocodile : "Crocodiles identiques";

        Object premier = animaux[indicePremierCrocodile];
        Object second = animaux[indiceSecondCrocodile];

        // C'est ici que ça devient inutilement compliqué et propice aux erreurs!

        if (premier != null && second != null) {//le tableau statique peut contenir des null!
            Animal perdant;
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
            //On retire le crocodile qui a perdu. Il ne doit plus servir car il a été mangé.
            effaceCrocodile(perdant);
        }
    }


    /**
     * Fait combattre 2 crocodiles choisit au hasard.
     */
    public void combattre() {
        //On sélectionne 2 crocodile et on les fait combattre
        int nombreCrocodiles = animaux.length;
        assert nombreCrocodiles > 1 : "un seul crocodile";

        int premierCrocodile = (int) (Math.random() * nombreCrocodiles);
        int secondCrocodile = premierCrocodile;
        while (secondCrocodile == premierCrocodile || animaux[secondCrocodile] != null) {
            secondCrocodile = (int) (Math.random() * nombreCrocodiles);
        }
        combat(premierCrocodile, secondCrocodile);
    }

}
