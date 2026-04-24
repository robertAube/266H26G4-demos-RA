package cours_15a_tableauObjets_classeComparaisonPourTrier;

import java.util.ArrayList;
import java.util.Comparator;

public class ListePersonne {
    private ArrayList<Personne> listePersonne;

    public ListePersonne() {
        listePersonne = new ArrayList();
    }

    public void add(Personne personne) {
        listePersonne.add(personne);
    }

    public void faireCrier() {
        String str;
        for (Personne p : listePersonne) {
            str = p.getPrenom();
            str += " crie : " + p.crier();
            System.out.println(str);
        }
    }

    public void trierAvecComparable() {
        listePersonne.sort(Comparator.naturalOrder());
    }

    public void trierAvecClasse() {
        listePersonne.sort(new ComparateurPersonneNom());
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < listePersonne.size(); i++) {
            s += listePersonne.get(i) + "\n";
        }

        return s;
    }

}
