package solutionsFormatifs.Formatif3_sol.avecHeritage.milieu;

import java.util.ArrayList;

import solutionsFormatifs.Formatif3_sol.avecHeritage.animaux.*;


public class Riviere {

    public final static int NOMBRE_ANIMAUX_MIN = 2;
    public final static int NOMBRE_ANIMAUX_MAX = 10;

    private ArrayList<Animal> animaux;

    public Riviere(int nombreAnimaux) {
        assert nombreAnimaux >= NOMBRE_ANIMAUX_MIN : "Nombre inférieur à " + NOMBRE_ANIMAUX_MIN;
        assert nombreAnimaux <= NOMBRE_ANIMAUX_MAX : "Nombre supérieur à " + NOMBRE_ANIMAUX_MAX;

        animaux = new ArrayList<>();

        for (int i = 0; i < nombreAnimaux; i++) {
            if (i % 2 == 0) { //un crocodile
                double taille = Crocodile.TAILLE_MIN + Math.random() * (Crocodile.TAILLE_MAX - Crocodile.TAILLE_MIN);
                int nombreDents = (int) (Crocodile.NOMBRE_DE_DENTS_MIN +
                        Math.random() * (Crocodile.NOMBRE_DE_DENTS_MAX - Crocodile.NOMBRE_DE_DENTS_MIN));
                Crocodile nouveauCroco = Math.random() > 0.5 ?
                        new Crocodile(nombreDents, taille) :
                        new CrocodileWally(nombreDents, taille);
                animaux.add(nouveauCroco);
            } else { //un serpent
                double taille = Crocodile.TAILLE_MIN + Math.random() * (Crocodile.TAILLE_MAX - Crocodile.TAILLE_MIN);
                double longueur = Serpent.TAILLE_MIN + Math.random() * (Serpent.TAILLE_MAX - Serpent.TAILLE_MIN);
                Serpent nouveauSerpent = Math.random() < 0.3 ?
                        new SerpentMer(longueur, taille, (float) (Math.random() * 4.0)) :
                        new Serpent(longueur, taille);
                animaux.add(nouveauSerpent);
            }
        }
    }

    public void effaceAnimal(Animal animalAEffacer) {

        animaux.remove(animalAEffacer);
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
        assert indicePremierCrocodile < animaux.size() : "premier crocodile hors du tableau";
        assert indiceSecondCrocodile > 0 : "second crocodile index négatif";
        assert indiceSecondCrocodile < animaux.size() : "second crocodile hors du tableau";
        assert indicePremierCrocodile != indiceSecondCrocodile : "Crocodiles identiques";

        Animal premier = animaux.get(indicePremierCrocodile);
        Animal second = animaux.get(indiceSecondCrocodile);
        Animal perdant = null;

        // C'est redevenu simple!
        perdant = premier.combattre(second);

        //On retire le crocodile qui a perdu. Il ne doit plus servir car il a été mangé.
        animaux.remove(perdant);

    }

    /**
     * Fait combattre 2 crocodiles choisit au hasard.
     */
    public void combattre() {
        //On sélectionne 2 crocodile et on les fait combattre
        int nombreCrocodiles = animaux.size();
        assert nombreCrocodiles > 1 : "un seul crocodile";

        int premierCrocodile = (int) (Math.random() * nombreCrocodiles);
        int secondCrocodile = premierCrocodile;
        while (secondCrocodile == premierCrocodile) {
            secondCrocodile = (int) (Math.random() * nombreCrocodiles);
        }
        combat(premierCrocodile, secondCrocodile);
    }

    public ArrayList<Animal> getAnimaux() {
        return animaux;
    }
}
