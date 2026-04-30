package cours_21c_Arrays;

import java.util.Arrays;
import java.util.List;

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
    private int tabIntCopySort[];

    public DemoArrays() {
        afficherUnTableau();
        copierUnTableau();
        trierUnTableau();
        remplirUnTableau();
        rechercheDichotomiqueSurUnTableau();
        verifierEgaliteDeTableau();
        mettreUnTableauDansUneList();
    }

    private void afficherUnTableau() {
        System.out.println("tabInt" + tabInt); //affiche tabInt[I@1698c449
        System.out.println("tabInt" + Arrays.toString(tabInt)); //affichage propre d'un tableau!
    }

    /**
     * Copier un tableau en partie ou au complet
     */
    private void copierUnTableau() {
        System.out.println("Copier tabInt : ");
        tabIntCopySort = Arrays.copyOf(tabInt, tabInt.length);  //copie le tableau
        System.out.println("tabIntCopySort" + Arrays.toString(tabIntCopySort)); //affiche tabIntCopySort[7, 2, 9, 3, 6, 3];
    }

    private void remplirUnTableau() {
        //remplir un tableau
        System.out.println("\nArrays.fill(tabRempli, 7) : ");
        tabRempli = new int[10];
        Arrays.fill(tabRempli, 7); // remplir avec la valeur 7
        System.out.println("tabRempli" + Arrays.toString(tabRempli));

    }

    private void trierUnTableau() {
        //trier un tableau
        Arrays.sort(tabIntCopySort); //trie le tableau tabIntCopySort
        System.out.println("\nArrays.sort(tabInt) : ");
        System.out.println("tabIntCopySort = " + Arrays.toString(tabIntCopySort));
    }

    private void rechercheDichotomiqueSurUnTableau() {
        // Trouver la valeur dans le tableau valeursInt.
        // binarySearch retourne l'index de la clé de recherche.
        // IMPORTANT: le tableau doit être trié avant d'utiliser binarySearch, sinon le résultat est imprévisible.
        // Si la valeur renvoyée par la recherche binaire est supérieure ou égale à zéro,
        //   cette valeur correspond à l'indice de l'élément trouvé.
        for (int nbCherche = 1; nbCherche < 10; nbCherche++) {
            System.out.print("nb cherché " + nbCherche + " --> " );
            System.out.print("tabInt[" + Arrays.binarySearch(tabInt, nbCherche) + "] - "); //tableau non-trié: résultat imprévisible
            System.out.println("tabIntCopySort["+ Arrays.binarySearch(tabIntCopySort, nbCherche) + ']'); // tableau trié: résultat prévisible
        }

        //Note: Il N’existe PAS de méthode dans java.util.Arrays pour faire une recherche dans un tableau non trié.
        // On doit la faire nous même avec une boucle for.
    }

    private void verifierEgaliteDeTableau() {
        //Vérifier l'égalité d'un tableau
        System.out.println("\nArrays.equals(tabInt, tabIntCopySort) : ");
        System.out.println("tabInt" + Arrays.toString(tabInt));
        System.out.println("tabIntCopySort" + Arrays.toString(tabIntCopySort));
        System.out.print("\nArrays.equals(tabInt, tabIntCopySort) = ");
        System.out.println(Arrays.equals(tabInt, tabIntCopySort));
    }

    private void mettreUnTableauDansUneList() {
        Integer[] tab = {4, 7, 1}; //Remarquer qu'il faut avoir un tableau de Integer. Ça ne marcherait pas avec un type primitif comme int
        List<Integer> liste = Arrays.asList(tab);

        System.out.println("\nArrays.asList(tab) : ");
        System.out.println("tab" + Arrays.toString(tab));
        System.out.println("liste" + liste);
    }

    public static void main(String[] args) {
        new DemoArrays();
    }
}


