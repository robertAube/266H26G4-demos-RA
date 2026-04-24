package solutionsFormatifs.Formatif2_sol.Exercices_suppl.employeHeritage;

public class Comptable extends EmployeC  {
    public Comptable(String nom, String metier) {
        super(nom, metier);
    }

    public void travaille(){

        System.out.println("Je fais la comptabilité \n");
    }
}
