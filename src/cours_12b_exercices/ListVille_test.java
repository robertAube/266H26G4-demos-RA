package cours_12b_exercices;

import java.util.LinkedList;
import java.util.List;

public class ListVille_test {
    private ListVille lVilles;

    public ListVille_test() {
        lVilles = new ListVille();

        ajouterLesVilles();
        System.out.println(lVilles);

        lVilles.trier_PaysNom();
        System.out.println(lVilles);

        supprimer1Ville();
        System.out.println(lVilles);

    }

    private void supprimer1Ville() {
        lVilles.supprimer(new Ville("Beijing", "Chine"));
    }

    private void ajouterLesVilles() {
        List<Ville> listeVille = new LinkedList<>();
        // Ajout des villes
        listeVille.add(new Ville("Shanghai", "Chine", 29.9f));
        listeVille.add(new Ville("Dhaka", "Bangladesh", 23.9f));
        listeVille.add(new Ville("Le Caire", "Egypte", 22.1f));
        listeVille.add(new Ville("Beijing", "Chine", 21.9f));
        listeVille.add(new Ville("Mumbai", "Inde", 0f));
        listeVille.add(new Ville("Osaka", "Japon", 19.1f));
        listeVille.add(new Ville("Kolkata", "Inde", 15.1f));
        listeVille.add(new Ville("Tokyo", "Japon", 37.4f));
        listeVille.add(new Ville("Delhi", "Inde", 33.8f));
        listeVille.add(new Ville("São Paulo", "Brésil", 22.7f));
        listeVille.add(new Ville("Mexico City", "Mexique", 22.7f));
        listeVille.add(new Ville("San Jose", "Etats-Unis", 0.99f));
        listeVille.add(new Ville("San Jose", "Costa Rica", 0.35f));

        lVilles.ajouterList(listeVille);
    }

    public static void main(String[] args) {
        new ListVille_test();
    }
}
