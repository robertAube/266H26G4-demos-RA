package cours_04_Heritage;

public class Personne_test {
    public Personne_test() {
        tester_set();
    }

    private void tester_set() {
        Personne p1 = new Personne("Fortin" , "Denis");
        Personne p2 = new Personne("Boulanger" , "Louise");

        System.out.println(p1);
        p1.set(p2);
        System.out.println(p1);
    }

    public static void main(String[] args) {
        new Personne_test();
    }
}
