package cours_22_fichiers.fichiersExemples;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class File_Info {
    public static void main(String[] args) {
        File f;
        File_Info cf = new File_Info();
        URL url = cf.getClass().getResource("Rtest.txt");
        try {
            f = Paths.get(url.toURI()).toFile();
            if (f.exists()) {
                System.out.println("Information sur le fichier : " + f.getName());
                System.out.println("L'objet est un fichier ?  " + f.isFile());
                System.out.println("Nom absolu = " + f.getAbsolutePath());
                System.out.println("Le fichier peut être lu ?  " + f.canRead());
                System.out.println("Est un répertoire = " + f.isDirectory());
                System.out.println("Longueur du fichier = " + f.length());
            }
        } catch (Exception e) {
            System.out.println("Vérifiez bien que votre fichier existe dans Ressources..");
        }

    }
}
