package cours_11b_Comparable_sort;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Robert Aubé
 * @version 1.0
 */
public class PizzaArrayList {
    private ArrayList<Pizza> listPizza;

    public PizzaArrayList() {
        this.listPizza = new ArrayList<Pizza>();
    }

    public void ajouterPizza(Pizza p) {
        listPizza.add(p);
    }

    public void enleverPizza(int i) {
        listPizza.remove(i);
    }

    public void enleverPizza(Pizza p) {
        listPizza.remove(p);
    }

    public void avancerToutesLesPizzas() {
//        for (int i = 0; i < listPizza.size(); i++) {
//            listPizza.get(i).avancerX();
//        }
        for (Pizza pizza : listPizza) { //passe tous les éléments de la liste (pas le choix...)
            pizza.avancerX();
        }
    }

    public void trier() {
        listPizza.sort(Comparator.naturalOrder()); //les objets doivent implémenter Comparable
    }
    public void trierInverser() {
        listPizza.sort(Comparator.reverseOrder()); //les objets doivent implémenter Comparable
    }

    @Override
    public String toString() {
        return "PizzaArrayList{" +
                "listPizza=" + listPizza +
                '}';
    }
}
