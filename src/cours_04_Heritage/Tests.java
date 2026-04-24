package cours_04_Heritage;

public class Tests {
    public Tests() {
        tester_Heritage();
        tester_instanceof();
    }

    private void tester_instanceof() {
        Personne denis = new Personne("Fortin" , "Denis");
        Employe louise = new Employe("Boulanger" , "Louise", 222121);

        System.out.println(denis instanceof Object); //true
        System.out.println(denis instanceof Personne); //true
        System.out.println(denis instanceof Employe); //false

        System.out.println(louise instanceof Object); //true
        System.out.println(louise instanceof Personne); //true
        System.out.println(louise instanceof Employe); //true
    }

    private void tester_Heritage() {
        Personne personne = new Personne("Fortin" , "Denis");
        Employe employe = new Employe("Boulanger" , "Louise", 222121);

        System.out.println(personne);
        System.out.println(employe);

    }

    public static void main(String[] args) {
        new Tests();
    }
}
