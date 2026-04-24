package solutionsFormatifs.Formatif2_sol.Exercices_suppl.vehicule;

public class VehiculeMain {
    public static void main(String[] args) {
        //todo créez une interface afin de pouvoir éliminer tous les instanceof

        Object[] avions = getAvions();
        for (int i = 0; i < avions.length; i++) {
            //todo appeler la méthode navigue sur chaque bateaux ou hydravion. Pour y arriver vous aller devoir créer une interface



        }
        Object[] bateaux = getBateaux();
        for (int i = 0; i < bateaux.length; i++) {
            //todo appeler la méthode vole sur chaque avion ou hydravion. Pour y arriver vous aller devoir créer une autre interfaces

        }

    }

    private static Object[] getBateaux() {
        Object[] vehicules = { new Bateau(), new Hydravion()};
        return vehicules;
    }

    private static Object[] getAvions() {
        Object[] vehicules = {new Avion(), new Hydravion()};
        return vehicules;
    }
}
