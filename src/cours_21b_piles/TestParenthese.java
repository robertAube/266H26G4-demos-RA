package cours_21b_piles;


import org.junit.jupiter.api.parallel.Isolated;

import java.util.Stack;

public class TestParenthese {

    // Exercice :  complétez la méthode suivante :
    // note:
    // "abcd".charAt(1); //retourne 'b'
    /**
     * Retourne true si l’expression est bien parenthésée, false sinon
     * @param expression
     * @return true si l’expression est bien parenthésée, false sinon
     */
    public static boolean estBienParenthesee(String expression) {
        Stack <Character> pile = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                pile.push(c);
            } else if (c == ')') {
                char sommet;
                if (pile.empty()) {
                    return false;
                }
                sommet = pile.pop(); //sommet, c'Est l'élément au-dessus de la pile

                if (sommet != '(') {
                    return false;
                }
            }
        }
        return pile.empty();
    }

    // Tests
    public static void main(String[] args) {
        String[] tests = {
                "()", //true
                ")", //false
                "(", //false
                "(( ))", //true
                "(a + b)", //true
                "x((a + b) + (c + d)) + e", //true
                "x((a + b) + (c + (d)) + e", //false
                "((())", //false
                "())(" //falsew
//                "x[(a + b) + (c + d)] + e", //true
//                "x[(a + b) + (c + d)) + e", //faux
        };

        for (String test : tests) {
            System.out.println(test + " -> " + estBienParenthesee(test));
        }
    }
}