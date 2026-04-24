package solutionsFormatifs.Formatif2_sol.avecInterface.Application;

import solutionsFormatifs.Formatif2_sol.avecInterface.milieu.Riviere;

public class Application {

    public static void main(String[] args)
    {
       Riviere rv=new Riviere(4);
        System.out.println("Liste des animaux:");
        rv.getAnimaux();
        rv.combattre();
        System.out.println("les animaux qui restent après le combat sont:");
        rv.getAnimaux();

    }
}
