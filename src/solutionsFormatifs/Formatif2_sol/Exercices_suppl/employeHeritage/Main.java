package solutionsFormatifs.Formatif2_sol.Exercices_suppl.employeHeritage;


public class Main {
    public static EmployeC employes[];
   public static void main(String[] args) {

       employes= new EmployeC[4];
       employes[0]=new Comptable("Jean claude","Comptable");
       employes[1]=new Caissier("Julie","caissiere");
       employes[2]=new Patron("Van Dame","Gérant");
       employes[3]=new Caissier("Jean philipe","caissier");
       EmployeC employe = getEmployeAleatoire();
       System.out.println(employe);
       employe.travaille();
    }

    private static EmployeC getEmployeAleatoire() {
       return employes[(int) (Math.random()*employes.length)];

    }
}
