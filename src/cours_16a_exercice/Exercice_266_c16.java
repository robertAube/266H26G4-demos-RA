package cours_16a_exercice;

import java.util.*;

/**
 * Exemple 4.1 Les maps
 * - méthodes sur Map : get(k), put(k, v)
 * - map foreach
 * - méthodes sur Entry : getKey(), getValue(), setValue()
 */
public class Exercice_266_c16 {
    private String texte = Fables.fable_LeCorbeauEtLeRenard;
    private List<String> listMots;

    public Exercice_266_c16() {
        initListeMots();
        System.out.println("Voici la liste de mot sans doublon ---->");
        afficherListeDeMotSansDoublon();

        System.out.println("Voici la liste de mot et indiquer combien on retrouve de fois le mot ---->");
        afficherListeDeMotSansDoublonEtAvecLeurNbOccurences();
    }

    private void initListeMots() {
        String[] tabMot;

        System.out.println("Texte initiale ---->");
        System.out.println(texte);

        texte = nettoyerPhrase(texte);
        System.out.println("Texte nettoyé ---->");
        System.out.println(texte);
        tabMot = texte.split("\s+");

        listMots = new ArrayList<>(Arrays.asList(tabMot)); //Converti mon tableau en List
        System.out.println("Texte dans une liste ---->");
        System.out.println(listMots); //séparateur du split: espace(\s) de 1 à n fois(+)

        System.out.println("Il y a " + listMots.size() + " mots dans le texte.");
    }

    private void afficherListeDeMotSansDoublon() {
        //todo en utilisant la puissance des collections,
        // afficher la liste de mots sans doublon
        Set<String> setMots = new TreeSet<>(listMots);

        System.out.println("Il y a " + setMots.size() + " mots différents. Il sont : ");
        System.out.println(setMots);
    }


    private void afficherListeDeMotSansDoublonEtAvecLeurNbOccurences() {
        //todo en utilisant la puissance des collections afficher,
        // la liste de mots sans doublon et leur nombre de fois qu'on les retrouve dans la liste.
        Map<String, Integer> mapMots = new TreeMap();

        for (String mot : listMots) {
            if (!mapMots.containsKey(mot)) { // si le mot n'est pas dans les clés
                mapMots.put(mot, 1);
            } else {
                mapMots.put(mot, 1 + mapMots.get(mot)); //allons chercher combien il y en a actuellement, et ajoutons 1.
            }
        }

        System.out.println("Il y a " + mapMots.size() + " mots différents. Il sont : ");
        System.out.println(mapMots);
    }


    /**
     * Transformer la phrase en liste de mots
     *
     * @param phrase
     * @return
     */
    private static String nettoyerPhraseV1(String phrase) {
        String strPhraseRetour;
        strPhraseRetour = phrase.replace(',', ' ');
        strPhraseRetour = strPhraseRetour.replace('.', ' ');
        strPhraseRetour = strPhraseRetour.replace('\'', ' ');
        strPhraseRetour = strPhraseRetour.replace('\n', ' ');
        strPhraseRetour = strPhraseRetour.toLowerCase(Locale.CANADA_FRENCH);
        strPhraseRetour = strPhraseRetour.replaceAll("[^a-zàâéèêëîïôûù ]", "");
        strPhraseRetour = strPhraseRetour.replaceAll(" +", " "); //remplacer les "un espace" et plus par un seul espace

        return strPhraseRetour;
    }

    private static String nettoyerPhrase(String phrase) {
        String strPhraseRetour;
        strPhraseRetour = phrase.toLowerCase(Locale.CANADA_FRENCH);
        strPhraseRetour = strPhraseRetour.replaceAll("[^a-zàâéèêëîïôûù ]+", " "); //tout ce qui n’est pas une lettre autorisée en français, remplacer par un seul espace
        strPhraseRetour = strPhraseRetour.replaceAll(" +", " "); //remplacer les "un espace" et plus, par un seul espace
        strPhraseRetour = strPhraseRetour.trim(); //enlève espaces en début et fin

        return strPhraseRetour;
    }

    public static void main(String[] args) {
        new Exercice_266_c16();
    }
}
