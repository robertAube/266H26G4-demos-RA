package cours_25_Stack;

public class exercicePile_palindrome {
    public exercicePile_palindrome() {
        afficherEstUnPalindrome("radar");   // palindrome
        afficherEstUnPalindrome("bonjour"); // pas un palindrome
        afficherEstUnPalindrome("kayak"); // palindrome
    }

    private void afficherEstUnPalindrome(String str) {
        System.out.println("Le mot '" + str + "' " + (estPalindrome(str) ? "est " : "n'est pas ") + "un palindrome.");
    }

    /**
     * Retourne vrai si str est un palindrome
     * @param str
     * @return true si str est un palindrome
     */
    private boolean estPalindrome(String str) {
        //todo implémenter la méthode pour vérifier si str est un palindrome ou pas en utilisant Stack
        return true;
    }


    public static void main(String[] args) {
        new exercicePile_palindrome();
    }
}
