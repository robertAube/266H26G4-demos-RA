package cours_22_fichiers.c_fichierObjet.cb_Serialisation;

import cours_22_fichiers.c_fichierObjet.cb_Serialisation.Personne.*;

public class Tests {
    private String nomFichier = "testObjectPersonne.bin";
    ListePersonne listePersonne = new ListePersonne();

    public Tests() {
        ajouterDesPersonnes();

        if (FichierObjetInputOutput.ecrire(nomFichier, listePersonne)) {
            listePersonne = null;
            FichierObjetInputOutput.lireEtAfficher(nomFichier);
        }

    }

    public void ajouterDesPersonnes() {
        Object[][] tPersonne = TabPersonnes.tPersonne;
        Personne p = null;

        for (int i = 0; i < tPersonne.length; i++) {
            if (tPersonne[i][0].equals("Employe")) {
                p = new Employe((String)tPersonne[i][1], (String)tPersonne[i][2], (int)tPersonne[i][3]);
            }
            if (tPersonne[i][0].equals("Sportif")) {
                p = new Sportif((String)tPersonne[i][1], (String)tPersonne[i][2], (String)tPersonne[i][3]);
            }
            listePersonne.add(p);
        }
    }

    public static void main(String[] args) {
        new Tests();
    }
}
