package solutionsFormatifs.Formatif3_sol.avecHeritage.Application;


import solutionsFormatifs.Formatif3_sol.avecHeritage.milieu.Riviere;

public class Application {

    public static void main(String[] args)
    {
       Riviere rv=new Riviere(4);
        System.out.println("Liste des animaux:");
        for(int i=0;i<rv.getAnimaux().size();i++) {
            System.out.println(rv.getAnimaux().get(i));
        }
        rv.combattre();
        System.out.println("les animaux qui restent apres combat sont:");
        for(int i=0;i<rv.getAnimaux().size();i++) {
            System.out.println(rv.getAnimaux().get(i));
        }

    }
}
