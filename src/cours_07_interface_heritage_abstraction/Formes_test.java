package cours_07_interface_heritage_abstraction;

import java.util.ArrayList;

public class Formes_test {
    private ArrayList<Forme> listeFormes;
    public Formes_test() {
        listeFormes = new ArrayList<>();

        ajouterFormes();
        afficherFormes();
    }

    private void ajouterFormes() {
        listeFormes.add(new Carre(10));
        listeFormes.add(new Cercle(3));
        listeFormes.add(new Triangle(2,3));
    }

    private void afficherFormes() {
        for (int i = 0; i < listeFormes.size(); i++) {
            System.out.println(listeFormes.get(i));
        }
    }

    public static void main(String[] args) {
        new Formes_test();
    }
}
