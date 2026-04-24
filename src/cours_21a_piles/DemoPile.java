package cours_21a_piles;


import java.util.Stack;

public class DemoPile {
    Stack<Integer> pileEntier = new Stack<>();

    public DemoPile() {
        System.out.println(this);
        pileEntier.push(10);
        System.out.println(this);
        pileEntier.push(20);
        System.out.println(this);
        pileEntier.push(30);

        System.out.println(this);
        System.out.println("On dépile: " + pileEntier.pop());
        System.out.println(this);
        System.out.println("On dépile: " + pileEntier.pop());
        System.out.println(this);
        pileEntier.push(55);
        System.out.println(this);
        System.out.println("On dépile: " + pileEntier.pop());
        System.out.println(this);
        System.out.println("Jeter un coup d'œil: " + pileEntier.peek());
        System.out.println(this);
        System.out.println("On dépile: " + pileEntier.pop());
        System.out.println(this);
        System.out.println("On dépile: " + pileEntier.pop()); // pop d'une pile vide provoque une EmptyStackException
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        strB.append( "Contenu de la pile: " + pileEntier);
        strB.append( "\nLa pile est vide: " + pileEntier.empty());
        return strB.toString();
    }

    // Tests
    public static void main(String[] args) {
        new DemoPile();
    }
}