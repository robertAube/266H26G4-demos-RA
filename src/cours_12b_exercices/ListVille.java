package cours_12b_exercices;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListVille {
    private List<Ville> lVilles;

    public ListVille() {
        lVilles = new LinkedList<>();
    }

    public void add(Ville ville) {
        lVilles.add(ville);
    }

    /**
     * Trier par ville puis par nom de ville
     */
    public void trier_PaysNom() {
        lVilles.sort(Comparator.naturalOrder());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListVille [" + lVilles.size() + " éléments]\n");
        for (Ville v : lVilles) { //for-each loop (passe absolument toutes les éléments de lVilles
            sb.append(v + "\n");
        }
        return sb.toString();
    }

    public void ajouterList(List<Ville> listeVille) {
        lVilles.addAll(listeVille);
    }

    public void supprimer(Ville ville) {
        lVilles.remove(ville);
    }
}
