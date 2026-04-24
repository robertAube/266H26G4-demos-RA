package cours_22_fichiers.c_fichierObjet.cb_Serialisation.Personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class ListePersonne implements Serializable {
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
