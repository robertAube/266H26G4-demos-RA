package cours_11a_delegation;


interface Affichable {
    void imprimer(String texte); //doit faire l'affichage
}

class Imprimante {
    private final Affichable sortieDelegation; // délégation : Un objet confie une tâche à un autre objet.

    public Imprimante(Affichable sortie) {
        this.sortieDelegation = sortie;
    }

    public void imprimer(String texte) {
        // délégation : on redirige l’appel
        sortieDelegation.imprimer("\"" + texte + "\"");
    }
}

class Normal implements Affichable
{
    @Override
    public void imprimer(String texte) {
        String reset = "\u001B[0m";

        System.out.println(reset + texte);
    }
}

class Rouge implements Affichable {

    @Override
    public void imprimer(String texte) {
        String rouge = "\u001B[31m";
        String reset = "\u001B[0m";

        System.out.println(rouge + texte + reset);
    }
}

// Utilisation
public class Delegation {
    public static void main(String[] args) {
        Imprimante imprimante;

        Affichable normal = new Normal();
        imprimante = new Imprimante(normal);
        imprimante.imprimer("Bonjour délégation !");

        Affichable rouge = new Rouge();
        imprimante = new Imprimante(rouge);
        imprimante.imprimer("Bonjour délégation !");
    }
}