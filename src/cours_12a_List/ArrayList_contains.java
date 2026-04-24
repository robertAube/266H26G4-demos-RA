package cours_12a_List;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArrayList_contains {
    public static void main(String[] args) {
        ArrayList<Personne> lPersonne;
        Personne p1, p2;

        lPersonne = new ArrayList<Personne>();

        lPersonne.add(new Personne("Wayne", "John", LocalDate.of(1907, 5, 26)));
        lPersonne.add(new Personne("Lennon", "John", LocalDate.of(1940, 10, 9)));
        lPersonne.add(new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3)));
        lPersonne.add(new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19)));
        lPersonne.add(new Personne("Wayne", "John", LocalDate.of(1907, 5, 26)));

        // création des personnes pour remplir la liste
        p1 = new Personne("Wayne", "John", LocalDate.of(1907, 5, 26));
        p2 = new Personne("McQueen", "Steeve", LocalDate.of(1930, 3, 24));

        // recherche d’un élément dans la liste
        int position;
        position = lPersonne.indexOf(p1); //IMPORTANT: basé sur le equals de Personne
        if (position == -1) {
            System.out.println("non trouvé dans la liste");
        } else {
            System.out.println(lPersonne.get(position).getNom() + "trouvé à l'indice = " + position);
        }

        // La recherche débute à la fin de la liste
        position = lPersonne.lastIndexOf(p1);
        if (position == -1) {
            System.out.println("non trouvé dans la liste");
        } else {
            System.out.println(lPersonne.get(position).getNom() + "trouvé à l'indice = " + position);
        }
    }
}
