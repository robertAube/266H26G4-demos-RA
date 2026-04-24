package solutionsFormatifs.Formatif2_sol.Exercices_suppl.fruits;

public class FruitMain {
    public static void main(String[] args) {
        FruitI[] fruits = new FruitI[3];
        fruits[0] = new Orange();

        //todo Fabriquez 2 autres fruits  (mangue et banane) et mettez-en quelques intances dans le tableaux fruits;




        //On fait afficher le tout
        for (int i = 0; i < fruits.length; i++) {
            fruits[i].mange();
        }

    }
}
