package cours_03_ArrayList;

public class Liste_test {
    private Liste liste = new Liste();
    public Liste_test() {
        add_test();
        System.out.println(liste.toString());
    }

    private void add_test() {
        liste.add(new Produit("stylo", 1.99, 200));
        liste.add(new Produit("cahier", 4.50, 100));
        liste.add(new Personne("Fortin", "Denis"));
        liste.add("Bonjour le monde");
    }

    public static void main(String[] args) {
        new Liste_test();
    }
}
