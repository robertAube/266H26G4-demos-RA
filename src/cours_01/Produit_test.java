package cours_01;

public class Produit_test {
    public Produit_test() {
      //  test1();
        equals_tests();
    }

    private void equals_tests() {
        Produit p1 = new Produit("stylo", 1.99, 200);
        Produit p2 = new Produit("stylo", 1.99, 200);

        System.out.println(p1 + (p1.equals(p2) ? " = " : " != ") + p2 );

        p2.setNo(1000);

        System.out.println(p1 + (p1.equals(p2) ? " = " : " != ") + p2 );
    }

    private void test1() {
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
