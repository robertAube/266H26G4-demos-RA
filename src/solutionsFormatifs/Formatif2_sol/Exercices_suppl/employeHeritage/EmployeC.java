package solutionsFormatifs.Formatif2_sol.Exercices_suppl.employeHeritage;

public class EmployeC {
    String nom;
    String metier;

    @Override
    public String toString() {
        return "EmployeC{" +
                "nom='" + nom + '\'' +
                ", metier='" + metier + '\'' +
                '}';
    }

    public EmployeC(String nom, String metier) {
        this.nom = nom;
        this.metier = metier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public void travaille(){

    }
}
