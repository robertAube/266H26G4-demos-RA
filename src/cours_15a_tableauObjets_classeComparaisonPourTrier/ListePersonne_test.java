package cours_15a_tableauObjets_classeComparaisonPourTrier;

public class ListePersonne_test {
    ListePersonne listePersonne = new ListePersonne();

    public ListePersonne_test() {
        ajouterDesPersonnesV2();
        System.out.println(listePersonne);
        listePersonne.trierAvecComparable();
        System.out.println(listePersonne);
        listePersonne.trierAvecClasse();
        System.out.println(listePersonne);

        listePersonne.faireCrier();

    }

    private void ajouterDesPersonnesV1() {
        listePersonne.add(new Employe("Boulanger", "Louise", 23232));
        listePersonne.add(new Sportif("Gagné", "Yves", "luge"));
    }

    private void ajouterDesPersonnesV2() {
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
        new ListePersonne_test();
    }
}
