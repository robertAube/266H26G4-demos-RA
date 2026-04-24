package solutionsFormatifs.Formatif2_sol.Exercices_suppl.employeInstanceof;

public class EmployeMain {
    public static void main(String[] args) {

        Object employe = getEmployeAleatoire();

         if (employe instanceof Patron) {
            Patron patron = (Patron) employe;
            patron.travaille();
        } else {
            Caissier caissier = (Caissier) employe;
            caissier.travaille();
        }
    }

    private static Object getEmployeAleatoire() {

        return Math.random() > 0.5 ? new Patron() : new Caissier();
    }
}
