package cours_21c_CollectionsEtArrays;

import java.util.*;

/**
 * Démonstration de la classe <b>java.util.Collections</b> qui fournit des méthodes <b>static</b> (recherche, tri, etc.)
 * et qui manipulent des collections
 * Ajouter un tableau à une List et manipuler la liste avec la classe Collections
 * Collections.sort
 * Collections.reverse
 * Collections.swap
 * Collections.fill
 */
public class DemoCollections {
    private String couleurs[] = {"noir", "rouge", "blanc", "rouge", "vert", "gris", "blanc"};
    List<String> list;

    List<String>[] tabList = new List[]{
            new ArrayList(),
            new LinkedList()
    };

    public DemoCollections() {
        for (List<String> c : tabList) {
            list = c;
            jouerAvec_ClasseCollection();
        }
    }

    private void jouerAvec_ClasseCollection() {
        String nomList = list.getClass().getSimpleName();
        // Ajouter une couleur au tableau et à la List.
        list.add("jaune");

        //Ajouter des chaînes de couleur au tableau et à la List
        list.addAll(Arrays.asList(couleurs));

        // Afficher le contenu du tableau et de la liste
        System.out.println("###########\n" + nomList + " après l'ajout des couleurs : ");
        System.out.println(this);

        //Diverses manipulations sur la liste avec la classe Collections
        System.out.println("\nManipuler une " + nomList + " avec la classe Collections.");

        System.out.println("\nInverser une " + nomList);
        Collections.reverse(list);
        System.out.println(this);

        System.out.println("Trier une " + nomList);
        Collections.sort(list);
        System.out.println(this);

        System.out.println("\nPermuter '" + list.get(1) + "' avec '" + list.get(3) + "' dans une " + nomList);
        Collections.swap(list, 1, 3);
        System.out.println(list);

        System.out.println("\nRemplir une " + nomList + " avec juju");
        Collections.fill(list, "juju");
        System.out.println(this + "\n");
    }

    @Override
    public String toString() {
        return list.getClass().getSimpleName() + list;
    }

    // Exécuter l'application.
    public static void main(String[] args) {
        new DemoCollections();
    }
}
/**
 * Exécution pour l'ArrayList
 * ###########
 * ArrayList après l'ajout des couleurs :
 * ArrayList[jaune, noir, rouge, blanc, rouge, vert, gris, blanc]
 *
 * Manipuler une ArrayList avec la classe Collections.
 *
 * Inverser une ArrayList
 * ArrayList[blanc, gris, vert, rouge, blanc, rouge, noir, jaune]
 * Trier une ArrayList
 * ArrayList[blanc, blanc, gris, jaune, noir, rouge, rouge, vert]
 *
 * Permuter 'blanc' avec 'jaune' dans une ArrayList
 * [blanc, jaune, gris, blanc, noir, rouge, rouge, vert]
 *
 * Remplir une ArrayList avec juju
 * ArrayList[juju, juju, juju, juju, juju, juju, juju, juju]
 */