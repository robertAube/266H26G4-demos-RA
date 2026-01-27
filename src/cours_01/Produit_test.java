package cours_01;

public class Produit_test {
    public Produit_test() {
        Produit produit;

        produit = new Produit();

        produit.setPrix(10);

        System.out.println(produit.toString());

        produit.setPrix(-1);

        System.out.println(produit.toString());
    }

    public static void main(String[] args) {
        new Produit_test();
    }
}
