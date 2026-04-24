package solutionsFormatifs.Formatif1_sol.milieu;


import solutionsFormatifs.Formatif1_sol.animaux.Crocodile;

public class RiviereCrocodileTableauStatique {

    public final static int NOMBRE_CROCODILE_MIN = 2;
    public final static int NOMBRE_CROCODILE_MAX = 10;

    public Crocodile[] crocodiles;

    public RiviereCrocodileTableauStatique(int nombreCrocodile ) {

       // int nombreCrocodile = (int) (NOMBRE_CROCODILE_MIN
            //    + (Math.random() * NOMBRE_CROCODILE_MAX - NOMBRE_CROCODILE_MIN));

        crocodiles = new Crocodile[nombreCrocodile];

        for (int i = 0; i < nombreCrocodile; i++) {
            crocodiles[i] = new Crocodile();
        }
    }

    /**
     * Enlève un crocodile de la rivière. Il ne se passe rien si le crocodile n'existe pas.
     *
     * @param crocodileAEffacer Le crocodile qu'on veut effacer
     */
    public void effaceCrocodile(Crocodile crocodileAEffacer) {
        for (int i = 0; i < crocodiles.length; i++) {
            if (crocodiles[i].equals(crocodileAEffacer)) {
                crocodiles[i] = null;// Ça crée des trous dans le tableaux de crocodiles... Il faut les gérer
            }
        }
    }

    //Retourne les crocodiles du tableau
    public void getCrocodiles() {

        for (int i = 0; i < crocodiles.length; i++) {
           System.out.println("Crocodile " + i + ": " + crocodiles[i]);
        }
    }


    /**
     * Confronte 2 crocodiles. Le perdant est retiré de la rivière.
     */
    public void combat(int premierCrocodile, int secondCrocodile) {
        assert premierCrocodile > 0 : "premier crocodile index négatif";
        assert premierCrocodile < crocodiles.length : "premier crocodile hors du tableau";
        assert secondCrocodile > 0 : "second crocodile index négatif";
        assert secondCrocodile < crocodiles.length : "second crocodile hors du tableau";
        assert crocodiles[premierCrocodile] != null : "premier crocodile nul";
        assert crocodiles[secondCrocodile] != null : "second crocodile nul";

        Crocodile premier = crocodiles[premierCrocodile];
        Crocodile second = crocodiles[secondCrocodile];
        System.out.println("Crocodile " + premierCrocodile+"  VS  "+secondCrocodile);
        Crocodile perdant = premier.combattre(second);
        if(perdant==null)
        {
             System.out.println("Combat équilibré: Ni perdant ni gagnant ");
        }
        else
            {
            System.out.println("Le perdant est: " + trouveCrocodile(perdant));
            effaceCrocodile(perdant);
            }
    }

    /**
     * Retourne la position (indice +1) du Crocodile recherché
     *
     * @param crocodileRecherche le crocodile recherché.
     * @return la position du crocodile recherché.
     */

    public int trouveCrocodile(Crocodile crocodileRecherche) {
        int tr=-1;
        for (int i = 0; i < crocodiles.length; i++) {
            if (crocodiles[i].equals(crocodileRecherche)) {
                tr=i;
            }
        }
        return tr;


    }

    /**
     * Fait combattre 2 crocodiles choisit au hasard.
     */
    public void combattre() {
        //On sélectionne 2 crocodile et on les fait combattre
        int nombreCrocodiles = crocodiles.length;
        assert nombreCrocodiles > 1 : "un seul crocodile";

        int premierCrocodile = (int) (Math.random() * nombreCrocodiles);
        int secondCrocodile = premierCrocodile;
        while (secondCrocodile == premierCrocodile || crocodiles[secondCrocodile] == null) {
            secondCrocodile = (int) (Math.random() * nombreCrocodiles);
        }

        combat(premierCrocodile, secondCrocodile);
    }

}
