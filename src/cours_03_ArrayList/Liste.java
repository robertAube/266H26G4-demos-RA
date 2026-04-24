package cours_03_ArrayList;
//Robert
import java.util.ArrayList;

public class Liste {
    private ArrayList<Object> listeObjet;

    public Liste() {
        this.listeObjet = new ArrayList<>();
    }

    public void add(Object objet) {
        listeObjet.add(objet);
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0 ; i < listeObjet.size(); i++) {
            s += listeObjet.get(i) + ", ";
        }

        return s;
    }
}
