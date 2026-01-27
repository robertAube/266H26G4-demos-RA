package cours_01;

public class Inventaire_tests {
    private Inventaire inventaire = new Inventaire();

    public Inventaire_tests() {
        tester_add();
        System.out.println(inventaire);
    }

    private void tester_add() {
        inventaire.add(new Produit("stylo", 1.99, 200));
        inventaire.add(new Produit("cahier", 4.50, 100));
    }

    public static void main(String[] args) {
        new Inventaire_tests();
    }
}
