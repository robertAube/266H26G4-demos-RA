package cours_05_Interface_classe_abstraite;

import java.util.ArrayList;

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
        for (int i = 0; i < listePersonne.size(); i++) {
            str = listePersonne.get(i).getPrenom();
            str += " crie : " + listePersonne.get(i).crier();
            System.out.println(str);
        }
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
