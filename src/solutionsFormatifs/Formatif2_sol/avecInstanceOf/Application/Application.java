package solutionsFormatifs.Formatif2_sol.avecInstanceOf.Application;


import solutionsFormatifs.Formatif2_sol.avecInstanceOf.milieu.Riviere;

public class Application {

    public static void main(String[] args)
    {
        Riviere rv=new Riviere(4);
        System.out.println("Liste des animaux:");
        rv.getAnimaux();
        rv.combattre();
        System.out.println("les animaux qui restent apres combat sont:");
        rv.getAnimaux();

    }
}
