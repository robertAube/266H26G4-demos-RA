package cours_28_exercice_doublon;

import cours_28_exercice_doublon.Personne.*;

public class Tests {
    ListePersonne listePersonne = new ListePersonne();

    public Tests() {
        ajouterDesPersonnes();
        listePersonne.afficherDoublonsV1();



        listePersonne.afficherDoublonsV2();
    }

    public void ajouterDesPersonnes() {
        Object[][] tPersonne = TabPersonnes.tPersonne;
        Personne p = null;

        for (int i = 0; i < tPersonne.length; i++) {
            if (tPersonne[i][0].equals("Employe")) {
                p = new Employe((String)tPersonne[i][1], (String)tPersonne[i][2], (int)tPersonne[i][3]);
            }
            if (tPersonne[i][0].equals("Sportif")) {
                p = new Sportif((String)tPersonne[i][1], (String)tPersonne[i][2], (String)tPersonne[i][3]);
            }
            listePersonne.add(p);
        }
    }

    public static void main(String[] args) {
        new Tests();
    }
}
