package cours_01;

import java.util.Arrays;

public class Inventaire {
    private Produit[] listeProduit;
    private int nbElement;

    public Inventaire() {
        listeProduit = new Produit[10];
        nbElement = 0;
    }
//allo
    public void add(Produit p) {
        listeProduit[nbElement++] = p;
    }

    @Override
    public String toString() {
        return "Inventaire{" +
                "listeProduit=" + tabToString() +
                ", nbElement=" + nbElement +
                '}';
    }

    private String tabToString() {
        String str = "[";
        for (int i=0; i < nbElement; i++) {
            str += listeProduit[i] + ((i < nbElement - 1) ? ", " : "");
        }

        return  str + ']';
    }
}
