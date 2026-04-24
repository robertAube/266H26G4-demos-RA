package solutionsFormatifs.Formatif1_sol.milieu;


import solutionsFormatifs.Formatif1_sol.animaux.Crocodile;

import java.util.ArrayList;

public class RiviereCrocodileArrayList {

    public final static int NOMBRE_CROCODILE_MIN = 2;
    public final static int NOMBRE_CROCODILE_MAX = 10;


   // private Crocodile[] crocodiles;
   private ArrayList<Crocodile> crocodiles;

     public RiviereCrocodileArrayList(int nombreCrocodile ) {
        assert nombreCrocodile >= NOMBRE_CROCODILE_MIN : "Nombre inférieur à " + NOMBRE_CROCODILE_MIN;
        assert nombreCrocodile <= NOMBRE_CROCODILE_MAX: "Nombre supérieur à " + NOMBRE_CROCODILE_MAX;

       // crocodiles = new Crocodile[NOMBRE_CROCODILE_MAX ];
        crocodiles = new ArrayList<>(nombreCrocodile);
        for (int i = 0; i < nombreCrocodile; i++) {
            double taille = Crocodile.TAILLE_MIN + Math.random() * (Crocodile.TAILLE_MAX - Crocodile.TAILLE_MIN);
            int nombreDents = (int) (Crocodile.NOMBRE_DE_DENTS_MIN +
                    Math.random() * (Crocodile.NOMBRE_DE_DENTS_MAX - Crocodile.NOMBRE_DE_DENTS_MIN));
            //crocodiles[i]=new Crocodile(nombreDents, taille);
            crocodiles.add(new Crocodile(nombreDents, taille));

        }
    }

    public void effaceCrocodile(Crocodile crocodileAEffacer) {
        crocodiles.remove(crocodileAEffacer);
    }

    /**
     * Confronte 2 crocodiles choisi aléatorement ensembles. Le perdant est
     * retiré de la rivière.
     */
    public void combat(int premierCrocodile, int secondCrocodile) {
        assert premierCrocodile > 0 : "premier crocodile index négatif";
        assert premierCrocodile < crocodiles.size() : "premier crocodile hors du tableau";
        assert secondCrocodile > 0 : "second crocodile index négatif";
        assert secondCrocodile < crocodiles.size() : "second crocodile hors du tableau";
        assert premierCrocodile != secondCrocodile : "Crocodiles identiques";

        Crocodile premier = crocodiles.get(premierCrocodile);
        Crocodile second = crocodiles.get(secondCrocodile);

        Crocodile perdant = premier.combattre(second);

        //On retire le crocodile qui a perdu. Il ne doit plus servir car il a été mangé.
        crocodiles.remove(perdant);

        System.out.println("Les deux crocodiles en combat ont les identifiants suivants:"+ premier.getIdentifiant()+ " " +
                "et "+second.getIdentifiant()+" , le perdant est:"+perdant.getIdentifiant());

    }

    /**
     * Fait combattre 2 crocodiles choisit au hasard.
     */
    public void combattre() {
        //On sélectionne 2 crocodile et on les fait combattre
        int nombreCrocodiles = crocodiles.size();
        assert nombreCrocodiles > 1 : "un seul crocodile";

        int premierCrocodile = (int) (Math.random() * nombreCrocodiles);
        int secondCrocodile = premierCrocodile;
        while (secondCrocodile == premierCrocodile) {
            secondCrocodile = (int) (Math.random() * nombreCrocodiles);
        }
        combat(premierCrocodile, secondCrocodile);
    }

    public ArrayList<Crocodile> getCrocodiles() {
        return crocodiles;
    }
}
