package solutionsFormatifs.Formatif2_sol.avecInterface.animaux;

public interface Animal {
    Animal combattre(Animal opposant);
    double getForce();
    void ajouteRepas();

    double getTaille();
    void setTaille(double taille);
}
