package cours_17a_exercice;

import java.util.ArrayList;
import java.util.List;

public class SetEtudiants_tests {
    SetEtudiants setEtudiants;

    public SetEtudiants_tests() {
        testAdd();
        testGet();
        testReplace();
    }

    private SetEtudiants creerSetEtudiants() {
        List<Etudiant> liste = new ArrayList<>();
        liste.add(new Etudiant(211, "Marie"));
        liste.add(new Etudiant(162, "Lucie"));
        liste.add(new Etudiant(123, "Denis"));

        return new SetEtudiants(liste);
    }

    private void testAdd() {
        System.out.println("++++ testAdd ++++");

        setEtudiants = creerSetEtudiants();
        System.out.println(setEtudiants);

        //ajouter un étudiant qui n'existe pas déjà
        setEtudiants.add(new Etudiant(333, "Charlie"));
        System.out.println(setEtudiants);

        //ajouter un étudiant qui existe déjà : Dans un set: on ne remplace pas
        setEtudiants.add(new Etudiant(333, "Lise"));
        System.out.println(setEtudiants);

        System.out.println();
    }

    private void testGet() {
        Etudiant etudiant;
        System.out.println("++++ testGet ++++");

        setEtudiants = creerSetEtudiants();
        System.out.println(setEtudiants);

        etudiant = setEtudiants.get(123);
        System.out.println("Étudiant " + (etudiant == null ? "introuvable" : "trouvé") + " : " + etudiant);

        etudiant.setNom("Caroline");

        System.out.println(setEtudiants);

        etudiant = setEtudiants.get(666);
        System.out.println("Étudiant " + (etudiant == null ? "introuvable" : "trouvé") + " : " + etudiant);

        System.out.println();
    }

    private void testReplace() {
        System.out.println("++++ testReplace ++++");

        setEtudiants = creerSetEtudiants();
        System.out.println(setEtudiants);

        Etudiant oldEtudiant = new Etudiant(123, "");
        Etudiant newEtudiant = new Etudiant(123, "David");

        System.out.println("Remplacer " + oldEtudiant + " par " + newEtudiant);

        boolean success = setEtudiants.replace(oldEtudiant, newEtudiant);

        System.out.println("Remplacement réussi ? " + success);
        System.out.println(setEtudiants);
        System.out.println();
    }

    public static void main(String[] args) {
        new SetEtudiants_tests();
    }
}