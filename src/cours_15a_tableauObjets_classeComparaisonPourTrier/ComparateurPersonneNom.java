package cours_15a_tableauObjets_classeComparaisonPourTrier;

import java.util.Comparator;

public class ComparateurPersonneNom implements Comparator<Personne> {
    @Override
    public int compare(Personne p1, Personne p2) {
        return p1.getNom().compareTo(p2.getNom());
    }
}
