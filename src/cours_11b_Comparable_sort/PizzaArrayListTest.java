package cours_11b_Comparable_sort;

/**
 * @author Robert Aubé
 */
public class PizzaArrayListTest {
    private PizzaArrayList listPizza;
    public PizzaArrayListTest() {
        listPizza = new PizzaArrayList();
        ajouterDesPizzas();

        afficherDesPizzas();
        listPizza.trier();
        afficherDesPizzas();
        listPizza.trierInverser();
        afficherDesPizzas();
    }

    private void testerRetirerPizza() {
        listPizza.enleverPizza(0);
        System.out.println(listPizza.toString());
        listPizza.enleverPizza(new Pizza(5,1,"verte", 4));
        System.out.println("tester retire objet : " + listPizza.toString());
    }

    private void ajouterDesPizzas() {
        listPizza.ajouterPizza(new Pizza(1,1,"bleu", 1));
        listPizza.ajouterPizza(new Pizza(1,1,"rouge", 4));
        listPizza.ajouterPizza(new Pizza(1,1,"jaune", 2));
        listPizza.ajouterPizza(new Pizza(1,1,"verte", 4));
        listPizza.ajouterPizza(new Pizza(1,1,"mauve", 3));
    }
    private void afficherDesPizzas() {
        System.out.println(listPizza.toString());
    }
    private void avancerDesPizzas() {
        listPizza.avancerToutesLesPizzas();
    }
    public static void main(String[] args) {
        new PizzaArrayListTest();
    }
}
