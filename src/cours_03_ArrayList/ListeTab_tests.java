package cours_03_ArrayList;

public class ListeTab_tests {
    private ListeTab element = new ListeTab();

    public ListeTab_tests() {
        tester_add();
        System.out.println(element.toString());
    }

    private void tester_add() {
        element.add(new Produit("stylo", 1.99, 200));
        element.add(new Produit("cahier", 4.50, 100));
        element.add(new Personne("Fortin", "Denis"));
        element.add("Bonjour le monde");

    }

    public static void main(String[] args) {
        new ListeTab_tests();
    }
}
