package cours_22_fichiers.fichiersExemples;

import java.io.File;

public class Cfile {
    public static void main(String[] args)
    {
        //objet File
        File f = new File("test.txt");
        //affiche le chemin absolu + le nom du fichier
        System.out.println(f.getAbsolutePath());
        //si le fichier existe, on peut en savoir plus
        if (f.exists())
        {
            //afficher le nom du fichier, s’il est lisible (r) ou non (-) ,
            //s’il est modifiable (w) ou non(-) et sa taille en octets.
            System.out.println(f.getName() + " : " + (f.canRead() ? "r" : "-") +
                    (f.canWrite() ? "w" : "-") + " : " + f.length() );
            //supprimer le fichier
          f.delete();
            System.out.println("Le fichier "+f.getName() + " est deja supprime!!! ");
        }

    }
}
