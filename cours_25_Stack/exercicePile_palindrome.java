package cours_25_Stack;

import java.util.Stack;

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
        Stack<Character> pile = new Stack<>();

        // Empiler tous les caractères
        for (int i = 0; i < str.length(); i++) {
            pile.push(str.charAt(i));
        }

        // Comparer en dépilant
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != pile.pop()) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        new exercicePile_palindrome();
    }
}
