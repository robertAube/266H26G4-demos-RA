package cours_28_exercice_doublon.Personne;

import java.io.Serializable;
import java.util.*;

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

    public void afficherDoublonsV1() {
       //todo
    }
    /* affiche:
Doublon trouvé : Mon nom est Yves Savary. Je suis un Employe et mon salaire est : 85353
Doublon trouvé : Mon nom est Lucie Gagné. Je suis un Sportif et mon sport est : aviron
Doublon trouvé : Mon nom est Guy Ponton. Je suis un Employe et mon salaire est : 35350
Doublon trouvé : Mon nom est Guy Ponton. Je suis un Sportif et mon sport est : bicycle à pédales
     */

    public void afficherDoublonsV2() {
        //todo
    }

/* Affiche:
Guy Ponton
- Mon nom est Guy Ponton. Je suis un Employe et mon salaire est : 35353
- Mon nom est Guy Ponton. Je suis un Employe et mon salaire est : 35350
- Mon nom est Guy Ponton. Je suis un Sportif et mon sport est : bicycle à pédales
Lucie Gagné
- Mon nom est Lucie Gagné. Je suis un Sportif et mon sport est : luge
- Mon nom est Lucie Gagné. Je suis un Sportif et mon sport est : aviron
Yves Savary
- Mon nom est Yves Savary. Je suis un Employe et mon salaire est : 95353
*/
}
