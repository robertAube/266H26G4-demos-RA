package cours_17b_exception;


public class LancerException {
    public static int convertirStringToEntier(String strInt) {
        int resultat;
        resultat = Integer.parseInt(strInt);
        return resultat;
    }

    public static void afficherAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge ne peut pas être négatif");
        }
        System.out.println("Âge : " + age);
    }

    public static void retirer(double solde, double montantRetrait) throws IllegalArgumentException {

        if (montantRetrait > solde) {
            throw new MonIllegalArgumentException("Solde insuffisant");
        }
        System.out.println("Retrait accepté");
    }

    public static int diviser(int dividende, int diviseur)
            throws ArithmeticException, IllegalArgumentException {

        if (diviseur == 0) {
            throw new ArithmeticException("Division par zéro");
        }

        if (dividende < 0) {
            throw new IllegalArgumentException("Le dividende doit être positif");
        }

        return dividende / diviseur;
    }

    public static void tableauAfficher(int[] tableau, int index) {
        // Provoque une IndexOutOfBoundsException si l'index est invalide
        System.out.println(tableau[index]);
    }

    public static int tableauObtenirValeur(int[] tableau, int index) throws IndexOutOfBoundsException { //throws : exception propagée
        //todo Coder le corps de la méthode pour lancer une "manuellement" une IndexOutOfBoundsException si l'index est hors limite
        if (index < 0 || index >= tableau.length) {
            throw new IndexOutOfBoundsException("Index en dehors des limites : " + index);
        }

        return tableau[index];
    }
}
