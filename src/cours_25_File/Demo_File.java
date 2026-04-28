package cours_25_File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo_File {
    private static char fSep = File.separatorChar;
    private static String PATH = System.getProperty("user.dir") + fSep + "_fichiers" + fSep;

    public Demo_File() {
        String strNomFichier = PATH + "Denis.txt";
        testerGestionFichier(strNomFichier);
        testerGestionRepertoire(PATH + "repertoireTest");
    }

    private void testerGestionFichier(String strNomFichier) {
        try {
            File file = new File(strNomFichier); //Crée un path file
            System.out.println("file.getName() : " + file.getName());  //"Denis.txt"
            System.out.println("file.getPath() : " + file.getPath()); //
            System.out.println("file.getParent() : " + file.getParent());
            System.out.println("file.exists() : " + file.exists());

            System.out.println("On crée un fichier vide : ");
            file.createNewFile();

            System.out.println("file.exists() : " + file.exists());
            System.out.println("file.isDirectory() : " + file.isDirectory());
            System.out.println("file.isFile() : " + file.isFile());
            System.out.println("file.length() : " + file.length() + " octets");

            System.out.println("On supprime le fichier : ");
            file.delete();

            System.out.println("file.exists() : " + file.exists());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void testerGestionRepertoire(String repertoire) {
        File dir = new File(repertoire); //Crée un path file

        System.out.println("dir.getName() : " + dir.getName());
        System.out.println("dir.getPath() : " + dir.getPath());
        System.out.println("dir.getParent() : " + dir.getParent());
        System.out.println("dir.exists() : " + dir.exists());

        System.out.println("On crée un répertoire : ");
        dir.mkdirs(); // crée le dossier & les dossiers parents au besoin

        System.out.println("dir.exists() : " + dir.exists());
        System.out.println("dir.isDirectory() : " + dir.isDirectory());
        System.out.println("dir.isFile() : " + dir.isFile());

        System.out.println("Les fichiers et répertoires du répertoire '" + dir.getName() + "' sont : ");
        System.out.println(Arrays.toString(dir.listFiles()));

        System.out.println("Les fichiers et répertoires du répertoire '" + dir.getParent() + "' sont : ");
        System.out.println(Arrays.toString(new File(dir.getParent()).listFiles()));
    }
    public static void main(String[] args) {
        new Demo_File();
    }

}
