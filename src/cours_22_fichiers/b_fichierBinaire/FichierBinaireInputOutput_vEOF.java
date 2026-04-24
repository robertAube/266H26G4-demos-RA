package cours_22_fichiers.b_fichierBinaire;

import java.io.*;

public class FichierBinaireInputOutput_vEOF {
    //pour identifier où sera le fichier
    private static char fSep = File.separatorChar; //représente le caractère utilisé pour séparer les dossiers selon le système d’exploitation.
    private static String path = System.getProperty("user.dir") + fSep + "Ressources" + fSep; //System.getProperty("user.dir") retourne le répertoire de travail courant du programme Java

    private String nomFichier = "testBinEOF.bin";
    public static final Object[][] tEmploye = {
            {"Gagné", "Yves", 95353},
            {"Ponton", "Guy", 35353},
            {"Lessard", "Annie", 51125},
            {"Brière", "Julie", 51125},
    };


    public FichierBinaireInputOutput_vEOF() {
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
            DataOutputStream dos = new DataOutputStream(bos);

            for (int ligne = 0; ligne < data.length; ligne++) {
                String nom = (String) data[ligne][0];
                String prenom = (String) data[ligne][1];
                int salaire = (int) data[ligne][2];

                dos.writeUTF(nom);
                dos.writeUTF(prenom);
                dos.writeInt(salaire);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erreur le fichier n'est pas trouvé : " + nomFichier);
            e.printStackTrace();
            ecritureReussie = false;
        } catch (EOFException e) {
            System.out.println("Lecture réussi");
            ecritureReussie = true;
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
        int nbLigne;

        try {
            fis = new FileInputStream(nomFichier);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            while (true) {
                String nom = dis.readUTF();
                String prenom = dis.readUTF();
                int salaire = dis.readInt();
                System.out.println(nom + "; " + prenom + "; $" + salaire);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erreur le fichier n'est pas trouvé : " + nomFichier);
            e.printStackTrace();
            lectureReussie = false;
        } catch (EOFException e) {
            System.out.println("Fin du fichier atteinte");
            lectureReussie = true;
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture : " + nomFichier);
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
        new FichierBinaireInputOutput_vEOF();

    }
}
