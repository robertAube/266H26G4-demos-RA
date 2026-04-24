package cours_12a_List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArrayList_removeIf {
    public static void main(String[] args) {
        List<Personne> lPersonne;

        lPersonne = new ArrayList<Personne>();

        // création des personnes pour remplir la liste
        lPersonne.add(new Personne("Wayne", "John", LocalDate.of(1907, 5, 26)));
        lPersonne.add(new Personne("Lennon", "John", LocalDate.of(1940, 10, 9)));
        lPersonne.add(new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3)));
        lPersonne.add(new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19)));

        // suppression sélective de la liste
        // l’expression lambda détermine quels éléments seront supprimés
        // removeIf passe tous les éléments personne et si l'expression personne.getDateNaissance().getYear() < 1940 est vrai, il y a suppression de celui-ci
//        lPersonne.removeIf((Personne personne) -> personne.getDateNaissance().getYear() < 1940);
        lPersonne.removeIf((Personne personne) -> personne.getPrenom().equals("John"));

        // affichage des noms des  personnes de la liste après suppression
        System.out.println("Voici les noms des personnes dans la liste après suppression : ");
        for (Personne p : lPersonne) {
            System.out.println(p.getNom());
        }
    }
}
