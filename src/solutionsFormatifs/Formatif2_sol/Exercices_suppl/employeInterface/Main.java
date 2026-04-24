package solutionsFormatifs.Formatif2_sol.Exercices_suppl.employeInterface;


public class Main {
    public static EmployeI employes[];
   public static void main(String[] args) {

       employes= new EmployeI[4];
       employes[0]=new Comptable();
       employes[1]=new Caissier();
       employes[2]=new Patron();
       employes[3]=new Caissier();
       EmployeI employe = getEmployeAleatoire();
       employe.travaille();


     /*   if (employeInstanceof instanceof Patron) {
            Patron patron = (Patron) employeInstanceof;
            patron.travaille();
        } else {
            Caissier caissier = (Caissier) employeInstanceof;
            caissier.travaille();
        }*/
    }

    private static EmployeI getEmployeAleatoire() {

       return employes[(int) (Math.random()*employes.length)];

       // return Math.random() > 0.5 ? new Patron() : new Caissier();
    }
}
