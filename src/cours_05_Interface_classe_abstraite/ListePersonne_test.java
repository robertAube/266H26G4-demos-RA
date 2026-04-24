package cours_05_Interface_classe_abstraite;

public class ListePersonne_test {
    ListePersonne listePersonne = new ListePersonne();
    public ListePersonne_test() {
        ajouterDesPersonnes();
        System.out.println(listePersonne);

        listePersonne.faireCrier();
    }


    private void ajouterDesPersonnes() {
        listePersonne.add(new Employe("Boulanger", "Louise", 23232));
        listePersonne.add(new Sportif("Gagné", "Yves", "luge"));
    }

    public static void main(String[] args) {
        new ListePersonne_test();
    }
}
