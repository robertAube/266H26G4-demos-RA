package solutionsFormatifs.Formatif2_sol.Exercices_suppl.employeHeritage;

public class Caissier extends EmployeC {

    public Caissier(String nom, String metier) {
        super(nom, metier);
    }

    public void travaille(){
        System.out.println("Je vend les articles\n");
    }
}
