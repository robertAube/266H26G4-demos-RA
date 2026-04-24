package cours_15c_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Exemple1_Set {
    public static void main(String[] args) {
       Set<String> ensemble = new HashSet<>();
      // Set<String> ensemble = new TreeSet<>(); //trié en fonction du compare to de String
        ensemble.add("Java");
        ensemble.add("Python");
        ensemble.add("C++");
        ensemble.add("Java");

        // Récupération de l'itérateur
        Iterator<String> it = ensemble.iterator();

        // Parcours des éléments
        System.out.println("Parcourt des éléments par Itérateur: ");
        while (it.hasNext()) {
            String element = it.next();
            System.out.println("Élément : " + element);
        }

        System.out.println("Parcourt des éléments par foreach: ");
        for (String liquide : ensemble) {
            System.out.println(liquide);
        }
    }
}
