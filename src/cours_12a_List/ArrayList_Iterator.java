package cours_12a_List;

import java.time.LocalDate;
import java.util.*;

public class ArrayList_Iterator {
    public static void main(String[] args) {
        List<Personne> lPersonne;

//        lPersonne = new ArrayList<Personne>();
        lPersonne = new LinkedList<>();

        // création des personnes pour remplir la liste
        lPersonne.add(new Personne("Wayne", "John", LocalDate.of(1907, 5, 26)));
        lPersonne.add(new Personne("Lennon", "John", LocalDate.of(1940, 10, 9)));
        lPersonne.add(new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3)));
        lPersonne.add(new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19)));

        // insertion d’une personne entre position 0 et 1 donc à la position 1 de la liste
        lPersonne.add(1, new Personne("McQueen", "Steeve", LocalDate.of(1930, 3, 24)));

        System.out.println("Voici les personnes dans la liste 1 (Iterator):");
        // parcours de la première liste du début vers la fin
        Iterator<Personne> it; //unidirectionnel (début  fin) (impossible d'aller de la fin au début)
        it = lPersonne.iterator();
        Personne p;
        // tant qu’il reste des éléments

        while (it.hasNext()) {
            // récupération de l’élément courant
            p = it.next(); //retourne l'élément
            System.out.println(p.getNom());
        }

        System.out.println("Voici les personnes dans la liste 1  (ListIterator):");
        // parcours de la première liste de la fin vers le début récupération d’un ListIterator
        // positionné après le dernier élément (le nombre d’éléments de la liste)
        ListIterator<Personne> lit; // et les bidirectionnels (début  fin).
        lit = lPersonne.listIterator(lPersonne.size()); //positionner à la fin l'itérateur
        // tant qu’il reste des éléments
        while (lit.hasPrevious()) {
            // récupération de l’élément courant
            // en remontant dans la liste
            p = lit.previous(); //retourne l'élément
            System.out.println(p.getNom());
        }
    }
}
