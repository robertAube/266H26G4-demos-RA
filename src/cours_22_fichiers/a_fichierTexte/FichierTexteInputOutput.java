package cours_22_fichiers.a_fichierTexte;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FichierTexteInputOutput {
    //pour identifier où sera le fichier
    private static char fSep = File.separatorChar; //représente le caractère utilisé pour séparer les dossiers selon le système d’exploitation.
    private static String path = System.getProperty("user.dir") + fSep + "Ressources" + fSep; //System.getProperty("user.dir") retourne le répertoire de travail courant du programme Java

    private String nomFichier = "testTexte.txt";

    // Créer rapidement une liste avec des éléments. Celle-ci est immuable (je peux la changer)
    public static final List<String> lignes = List.of(
            "Première ligne",
            "Deuxième ligne",
            "Troisième ligne"
    );

    public FichierTexteInputOutput() {
        String filePath = path + nomFichier;

        if (ecrire(filePath, lignes)) {
            lireEtAfficher(filePath);
        }
    }

    /**
     * Écrire un fichier texte
     * @param nomFichier
     * @param listeLigne
     * @return
     */
    private static boolean ecrire(String nomFichier, List<String> listeLigne) {
        boolean ecritureReussie = true;
        BufferedWriter buffer = null;
        FileWriter flux = null;

        try {
            flux = new FileWriter(nomFichier, false);
            buffer = new BufferedWriter(flux);

            try {
                for (String ligne : listeLigne) {
                    //buffer.write(ligne, 0, ligne.length());
                    buffer.write(ligne);
                    buffer.newLine();
                }

            } catch (IOException e) {
                System.out.println("Erreur lors de l'écriture du fichier : " + nomFichier + "\n" + e.getMessage());
                e.printStackTrace();
                ecritureReussie = false;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erreur lors de l'ouverture du fichier : " + nomFichier + "\n" + e.getMessage());
            e.printStackTrace();
            ecritureReussie = false;
        } catch (IOException e) {
            System.out.println("Erreur à l'écriture : " + nomFichier + "\n" + e.getMessage());
            e.printStackTrace();
            ecritureReussie = false;
        } finally {
            try {
                if (buffer != null)
                    buffer.close();  //IMPORTANT
                if (buffer != null)
                    flux.close();
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture" + nomFichier + "\n" + e.getMessage());
                e.printStackTrace();
                ecritureReussie = false;
            }
        }

        return ecritureReussie;
    }

    private static boolean lireEtAfficher(String nomFichier) {
        boolean ecritureReussie = true;
        String ligne;

        try {
            BufferedReader entree = new BufferedReader(new FileReader(nomFichier, StandardCharsets.UTF_8));

            try {

                ligne = entree.readLine();
                while (ligne != null) { //si pas fin de fichier
                    System.out.println(ligne);
                    ligne = entree.readLine();
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de l'écriture du fichier : " + nomFichier + e.getMessage());
                e.printStackTrace();
                ecritureReussie = false;
            }

            entree.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erreur lors de l'ouverture du fichier : " + nomFichier + e.getMessage());
            e.printStackTrace();
            ecritureReussie = false;
        } catch (IOException e) {
            System.out.println("Erreur lors de la fermeture" + nomFichier + e.getMessage());
            e.printStackTrace();
            ecritureReussie = false;
        } finally {

        }

        return ecritureReussie;
    }

    public static void main(String arguments[]) {
        new FichierTexteInputOutput();
    }
}
