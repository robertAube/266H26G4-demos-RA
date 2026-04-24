package solutionsFormatifs.Formatif3_sol.avecHeritage.animaux;

public class CrocodileWally extends Crocodile{
    @Override
    public Animal combattre(Animal opposant){
        return Math.random()>0.5 ? super.combattre(opposant): null;
    }

    public CrocodileWally(int nombreDeDents, double taille) {

        super(nombreDeDents, taille);
    }
}
