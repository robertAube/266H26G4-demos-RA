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

    public void afficherDoublonsV1String() {
       //todo
        Set<String> set = new HashSet<>();
        String strId;
        for(Personne p : listePersonne) {
            strId = p.getPrenom() + " " + p.getNom();
            if (!set.add(strId)) {
                System.out.println("Doublon trouvé : " + p);
            }
        }
    }


    public void afficherDoublonsV1() {
        //todo
        Set<Personne> set = new HashSet<>();

        for(Personne p : listePersonne) {
            if (!set.add(p)) {
                System.out.println("Doublon trouvé : " + p);
            }
        }
    }

    /* affiche:
Doublon trouvé : Mon nom est Yves Savary. Je suis un Employe et mon salaire est : 85353
Doublon trouvé : Mon nom est Lucie Gagné. Je suis un Sportif et mon sport est : aviron
Doublon trouvé : Mon nom est Guy Ponton. Je suis un Employe et mon salaire est : 35350
Doublon trouvé : Mon nom est Guy Ponton. Je suis un Sportif et mon sport est : bicycle à pédales
     */

    public void afficherDoublonsV2() {
        //todo
        Map<String, ArrayList<Personne>> map;

        map = getMapRegroupement();

        afficherRegroupementPlusDe1(map);
    }

    private void afficherRegroupementPlusDe1V1(Map<String, ArrayList<Personne>> map) {
        for (Map.Entry<String, ArrayList<Personne>> entry : map.entrySet()) { //
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getKey());
                for (Personne p : entry.getValue()) {
                    System.out.println("- " + p);
                }
            }
        }
    }

    //avec lambda expression :
    private void afficherRegroupementPlusDe1(Map<String, ArrayList<Personne>> map) {
        map.forEach ((String key, ArrayList<Personne> value) -> { //
                    if (value.size() > 1) {
                        System.out.println(key);
                        for (Personne p : value) {
                            System.out.println("- " + p);
                        }
                    }
                }
        );
    }


    private Map<String, ArrayList<Personne>> getMapRegroupement() {
        Map<String, ArrayList<Personne>> map = new HashMap<>();
        String strId;

        for (Personne p : listePersonne) {
            strId = p.getPrenom() + " " + p.getNom();
            if (!map.containsKey(strId)) {
                ArrayList<Personne> lp = new ArrayList<>();
                lp.add(p);
                map.put(strId, lp);
            }  else {
                map.get(strId).add(p);
            }
        }

        return map;
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
- Mon nom est Yves Savary. Je suis un Employe et mon salaire est : 85353
*/
}
