package solutionsFormatifs.Formatif1_sol.animaux;


import solutionsFormatifs.Formatif1_sol.milieu.RiviereCrocodileTableauStatique;

public class Application {
    Crocodile croc1, croc2, croc3, croc4;

    public Application() {
        tester_crocodile();
        tester_Riviere();
    }

    private void tester_crocodile() {
        Crocodile croc1 = new Crocodile();
        Crocodile croc2 = new Crocodile(120, 4.8);

        System.out.println("création d'un crocodile avec les paramètres par défaut: " + croc1);
        System.out.println("création d'un crocodile avec paramètres: " + croc2);

        System.out.println("Dentier du crocodile 2:");
        for (int i = 0; i < croc2.getDents().length; i++) {
            System.out.print("[" + croc2.getDents()[i] + "]");
        }
    }

    private void tester_Riviere() {
        RiviereCrocodileTableauStatique riv = new RiviereCrocodileTableauStatique(4);

        riv.crocodiles[0] = new Crocodile();
        riv.crocodiles[1] = new Crocodile(120, 4.8);
        riv.crocodiles[2] = new Crocodile(140, 3.9);
        riv.crocodiles[3] = new Crocodile(80, 4.5);

        System.out.println("\n Liste des crocodiles:");
        riv.getCrocodiles();

        riv.combattre();

        System.out.println("les crocodiles qui restent apres combat sont:");
        riv.getCrocodiles();
    }

    public static void main(String[] args) {
        new Application();


    }
}
