package cours_03_ArrayList;

public class ListeTab {
    private Object[] listeProduit;
    private int nbElement;

    public ListeTab() {
        listeProduit = new Object[10];
        nbElement = 0;
    }

    public void add(Object object) {
        listeProduit[nbElement++] = object;
    }


    @Override
    public String toString() {
        return "Liste d'objuets{" +
                "listeProduit=" + tabToString() +
                ", nbElement=" + nbElement +
                '}';
    }

    private String tabToString() {
        String str = "[";
        for (int i = 0; i < nbElement; i++) {
            //Polymorphisme : le comportement change en fonction du type de l'objet à l'exécution
            str += listeProduit[i].toString() + ((i < nbElement - 1) ? ", " : "");
        }

        return str + ']';
    }
}
