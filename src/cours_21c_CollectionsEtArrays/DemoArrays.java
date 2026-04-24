package cours_21c_CollectionsEtArrays;

import java.util.Arrays;

/**
 * Démonstration de la classe Arrays
 * Cette classe fournit des méthodes <b>static</b> pour la manipulation des tableaux statiques
 * Arrays.copyOf
 * Arrays.fill
 * Arrays.sort
 * Arrays.binarySearch
 * Arrays.toString
 */
public class DemoArrays {
    private int tabInt[] = {7, 2, 9, 3, 6, 3};
    private int tabRempli[];
    private int tabIntCopySort[] ;


    public DemoArrays() {
        //copier un tableau en partie ou au complet
        System.out.println("Copier tabInt : ");
        System.out.println("tabInt" + tabInt);
        System.out.println("tabInt" + Arrays.toString(tabInt));
        tabIntCopySort = Arrays.copyOf(tabInt, tabInt.length);
        System.out.println("tabIntCopySort" + Arrays.toString(tabIntCopySort));

        //trier un tableau
        Arrays.sort(tabIntCopySort); //trier
        System.out.println("\nArrays.sort(tabInt) : " );
        System.out.println("tabIntCopySort = " + Arrays.toString(tabIntCopySort));

        //remplir un tableau
        System.out.println("\nArrays.fill(tabRempli, 7) : ");
        tabRempli = new int[10];
        Arrays.fill(tabRempli, 7); // remplir avec la valeur 7
        System.out.println("tabRempli" + Arrays.toString(tabRempli));

        //recherche dichotomique sur un tableau
        System.out.println("\nArrays.binarySearch(tabInt) : ");
        System.out.println("tabInt" + Arrays.toString(tabInt));
        System.out.println("tabIntCopySort" + Arrays.toString(tabIntCopySort));

        // Trouver la valeur dans le tableau valeursInt.
        // binarySearch retourne l'index de la clé de recherche, 
        // Si la valeur renvoyée par la recherche binaire est supérieure ou égale à zéro,
        //   cette valeur correspond à l'indice de l'élément trouvé
        for (int nbCherche = 1; nbCherche < 10; nbCherche++) {
            System.out.print("nb cherché " + nbCherche + " --> " );
            System.out.print("tabInt[" + Arrays.binarySearch(tabInt, nbCherche) + "] - ");
            System.out.println("tabIntCopySort["+ Arrays.binarySearch(tabIntCopySort, nbCherche) + ']');
        }

        //Vérifier l'égalité d'un tableau
        System.out.println("\nArrays.equals(tabInt, tabIntCopySort) : ");
        System.out.println("tabInt" + Arrays.toString(tabInt));
        System.out.println("tabIntCopySort" + Arrays.toString(tabIntCopySort));
        System.out.print("\nArrays.equals(tabInt, tabIntCopySort) = ");
        System.out.println(Arrays.equals(tabInt, tabIntCopySort));
    }

    public static void main(String[] args) {
        new DemoArrays();
    }
}


