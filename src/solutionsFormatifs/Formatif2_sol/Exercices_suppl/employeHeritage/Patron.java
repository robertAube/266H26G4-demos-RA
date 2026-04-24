package solutionsFormatifs.Formatif2_sol.Exercices_suppl.employeHeritage;


public class Patron extends EmployeC {


    public Patron(String nom, String metier) {
        super(nom, metier);
    }

    public void travaille(){

        System.out.println("Je prend les décisions\n");
    }
}
