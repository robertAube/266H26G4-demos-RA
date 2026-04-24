package cours_22_fichiers.c_fichierObjet.ca_fichierObjet;

import java.io.*;

public class FichierObjetInputOutput {
    //pour identifier où sera le fichier
    private static char fSep = File.separatorChar; //représente le caractère utilisé pour séparer les dossiers selon le système d’exploitation.
    private static String path = System.getProperty("user.dir") + fSep + "ressources" + fSep; //System.getProperty("user.dir") retourne le répertoire de travail courant du programme Java

    private String nomFichier = "testObject.bin";
    public static final Object[][] tEmploye = {
            {"Gagné", "Yves", 95353},
            {"Ponton", "Guy", 35353},
            {"Lessard", "Annie", 51125},
            {"Brière", "Julie", 51125},
    };


    public FichierObjetInputOutput() {
        Integer I;
        String filePath = path + nomFichier;
        if (ecrire(filePath, tEmploye)) {
            lireEtAfficher(filePath);
        }
    }

    private static boolean ecrire(String nomFichier, Object[][] data) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        boolean ecritureReussie = true;

        try {
            fos = new FileOutputStream(nomFichier);
            bos = new BufferedOutputStream(fos); //optionnel, mais recommandé surtout si le fichier est gros.
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(data);
        } catch (FileNotFoundException e) {
            System.out.println("Erreur le fichier n'est pas trouvé : " + nomFichier);
            e.printStackTrace();
            ecritureReussie = false;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture : " + nomFichier);
            e.printStackTrace();
            ecritureReussie = false;
        } finally {
            try {
                if (fos != null) { //si le fichier est ouvert
                    bos.close(); //IMPORTANT!!!!
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture : " + nomFichier);
                e.printStackTrace();
                ecritureReussie = false;
            }
        }

        return ecritureReussie;
    }


    private static boolean lireEtAfficher(String nomFichier) {
        FileInputStream fis = null;
        boolean lectureReussie = true;

        try {
            fis = new FileInputStream(nomFichier);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            Object[][] data = (Object[][])ois.readObject(); //cast obligatoire

            for (int ligne = 0; ligne < data.length; ligne++) {
                String nom = (String) data[ligne][0];
                String prenom = (String) data[ligne][1];
                int salaire = (int) data[ligne][2];

                System.out.println(nom + "; " + prenom + "; $" + salaire);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur le fichier n'est pas trouvé : " + nomFichier);
            e.printStackTrace();
            lectureReussie = false;
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture : " + nomFichier);
            e.printStackTrace();
            lectureReussie = false;
        } catch (ClassNotFoundException e) { // Se produit si ne trouve pas la définition d’une classe utilisée dans l’objet lu. Exemple la classe n'existe pas
            System.out.println("La classe n'existe pas.");
            e.printStackTrace();
            lectureReussie = false;
        } finally {
            try {
                if (fis != null) { //si le fichier est ouvert
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture : " + nomFichier);
                e.printStackTrace();
                lectureReussie = false;
            }
        }

        return lectureReussie;
    }

    public static void main(String arguments[]) {
        new FichierObjetInputOutput();

    }
}
