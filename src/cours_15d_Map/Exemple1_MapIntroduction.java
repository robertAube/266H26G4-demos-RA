package cours_15d_Map;

import java.util.*;

public class Exemple1_MapIntroduction {
    //tableau des types de map
    private Map<String, Integer>[] tabMap = new Map[]{
            new TreeMap<>(), //ordonné par clé
            new HashMap<>(), //sans ordre
            new Hashtable<>() //sans ordre - threadsafe
    };
    private Map<String, Integer> map;
    private Iterator<Map.Entry<String, Integer>> iter;

    public Exemple1_MapIntroduction() {
        for (Map<String, Integer> m : tabMap) {
            map = m;
            peupler();
            System.out.println("#######\nmap initial : " + this);
            jouer();
        }
    }

    private void peupler() {
        map.put("c", 10);
        map.put("f", 20);
        map.put("k", 30);
        map.put("x", 40);
        map.put("p", 50);
        map.put("g", 60);
        map.put("g", 99); //écrase 60 qui était associé à g. xxx
    }

    private void jouer() {
        // retrouver la valeur associée a la cle "f"
        System.out.println("valeur associée à f : " + map.get("f")); //20

        // modification de la valeur associée a la clé x avec pur
        System.out.println("\nliste des valeurs avant modification de x : " + this);
        map.put("x", 75);
        System.out.println("liste des valeurs après modification de x : " + this + '\n');

        // On supprime l'entrée par cle. Ici, on supprime l'entrée "k"
        System.out.println("map avant suppression de la clé k : " + this);
        // supprimer la valeur associée à la clé directement de la map
        // renvoie la valeur associée à la clé ou null si la clé est absente
        map.remove("k");
        System.out.println("map avant suppression de la clé k : " + this + '\n');

        // liste des clés et des valeurs
        System.out.println("liste des clés : " + getCles());
        System.out.println("liste des valeurs : " + getValeurs() + '\n');

        // on supprime l'élément la valeur 60
        System.out.println("map avant suppression de la valeur 99 : " + this);
        supprimerParValeur(99); // on supprime la valeur 60
        System.out.println("map après suppression de la valeur 99 : " + this + '\n');
    }

    /**
     * Pour obtenir toutes les clés d'une Map, on passe par un set
     *
     * @return toutes les <b>clés</b> de la map
     */
    public Set<String> getCles() {
        Set<String> set = map.keySet(); // attention, ici Set
        return set;
    }

    /**
     * Pour obtenir toutes les valeurs d'une Map, on passe par une collection
     *
     * @return toutes les <b>valeurs</b> de la map
     */
    public Collection<Integer> getValeurs() {
        Collection<Integer> valeurs = map.values(); // Collection
        return valeurs;
    }

    public void supprimerParValeur(Integer valeur) {
        // supprimer la valeur, on passe par la collection
        Collection<Integer> valeurs = map.values();
        valeurs.remove(valeur);
    }

    @Override
    public String toString() {
        return map.getClass().getSimpleName() + map;
    }

    public static void main(String args[]) {
        new Exemple1_MapIntroduction();
    }
}
