package cours_22_fichiers.c_fichierObjet.cb_Serialisation;

import java.io.*;

public class FichierObjetInputOutput {
    //pour identifier où sera le fichier
    private static char fSep = File.separatorChar; //représente le caractère utilisé pour séparer les dossiers selon le système d’exploitation.
    private static String path = System.getProperty("user.dir") + fSep + "ressources" + fSep; //System.getProperty("user.dir") retourne le répertoire de travail courant du programme Java

    public static boolean ecrire(String nomFichier, Object data) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        boolean ecritureReussie = true;

        try {
            fos = new FileOutputStream(path + nomFichier);
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


    public static boolean lireEtAfficher(String nomFichier) {
        FileInputStream fis = null;
        boolean lectureReussie = true;

        try {
            fis = new FileInputStream(path + nomFichier);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            Object data = ois.readObject();

            System.out.println(data);
        } catch (FileNotFoundException e) {
            System.out.println("Erreur le fichier n'est pas trouvé : " + nomFichier);
            e.printStackTrace();
            lectureReussie = false;
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture : " + nomFichier);
            e.printStackTrace();
            lectureReussie = false;
        } catch (
                ClassNotFoundException e) { // Se produit si ne trouve pas la définition d’une classe utilisée dans l’objet lu. Exemple la classe n'existe pas
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
}
