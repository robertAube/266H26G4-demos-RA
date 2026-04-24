package cours_13_ListIterator;
//Robert

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Liste {
    private ArrayList<Object> listeObjet;

    public Liste() {
        this.listeObjet = new ArrayList<>();
    }

    public void add(Object objet) {
        listeObjet.add(objet);
    }

    //todo exercices en classe
    @Override
    public String toString() {
        String s;

//        s = classique();
//        s = foreach();
//        s = Iterator();
//        s = IteratorAvecFor();
//        s = ListIterator();
        s = ListIteratorAvecRemove();

        return s;
    }

    public String classique() {
        String s = "";

        for (int i = 0; i < listeObjet.size(); i++) {
            s += listeObjet.get(i) + ", ";
        }

        return s;
    }

    public String foreach() {
        String s = "";

        for (Object o : listeObjet) {
            s += o + ", ";
        }

        return s;
    }

    public String Iterator() {
        String s = "";

        Iterator<Object> itO = listeObjet.iterator();
        while (itO.hasNext()) {
            s += itO.next() + ", ";
        }

        return s;
    }

    public String IteratorAvecFor() {
        String s = "";

        //équivalent au foreach
        for (Iterator<Object> itO = listeObjet.iterator(); itO.hasNext(); ) {
            s += itO.next() + ", ";
        }

        return s;
    }

    public String ListIterator() {
        String s = "";

        ListIterator<Object> itO = listeObjet.listIterator();
        while (itO.hasNext()) {
            s += itO.next() + ", ";
        }
        s += '\n';
        while (itO.hasPrevious()) {
            s += itO.previous() + ", ";
        }

        return s;
    }

    public String ListIteratorAvecRemove() {
        String s = "";

        ListIterator<Object> itO = listeObjet.listIterator();
        while (itO.hasNext()) {
            Object o = itO.next();
            if (o.equals("Bonjour le monde")) {
                itO.remove();
            }
            s += o + ", ";
        }
        s += '\n';
        while (itO.hasPrevious()) {
            s += itO.previous() + ", ";
        }

        return s;
    }
}
