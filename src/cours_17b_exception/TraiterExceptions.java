package cours_17b_exception;

public class TraiterExceptions {
    public TraiterExceptions() {
       // LancerException.convertirStringToEntier("abc");

 //       traiterTableau();

 //       trairerConvertirStringToEntier();
 //       traiterAfficherAge();
 //       traiterRetirer();
//        traiterDiviser();
        demo_printStackTrace();
    }

    public void traiterTableau()  {
        int t[] = {1, 2, 3, 4};
        int valeur = 0;
        System.out.println("Traitement tableau");
     //   valeur = LancerException.tableauObtenirValeur(t, 9);
        try { // pour traiter les esceptions
            valeur = LancerException.tableauObtenirValeur(t, 3);
            valeur = LancerException.tableauObtenirValeur(t, 9);
            System.out.println("Traitement réussie");
        } catch (IndexOutOfBoundsException e) { //quoi si exception?
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Fin du traitement de la conversion: " + valeur);
    }


    public void trairerConvertirStringToEntier() {
        System.out.println("Traitement de la conversion de String à entier");
        try {
            LancerException.convertirStringToEntier("231");
            LancerException.convertirStringToEntier("abc");
            System.out.println("Conversion réussie");
        } catch (RuntimeException e) {
            System.out.println("Erreur lors de la conversion : " + e.getMessage());
        }
        System.out.println("Fin du traitement de la conversion");
    }

    public static void traiterAfficherAge() {
        System.out.println("Traitement de l'affichage de l'âge");
        try {
            LancerException.afficherAge(-25);
            System.out.println("Âge affiché avec succès");
        } catch (IllegalArgumentException e) {
            System.out.println("L'âge ne peut pas être négatif : " + e.getMessage());
        }
        System.out.println("Fin du traitement de l'affichage de l'âge");
    }

    public static void traiterRetirer() {
        double solde = 100.0;
        double montantRetrait = 150.0;

        System.out.printf("Traitement du retrait de %.2f avec un solde de %.2f%n", montantRetrait, solde);
        try {
            LancerException.retirer(solde, montantRetrait);
            System.out.println("Retrait effectué avec succès");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors du retrait : " + e.getMessage());
        }
        System.out.println("Fin du traitement du retrait");
    }

    public void traiterDiviser() {
        int reponse;
        System.out.println("Traitement de la division de 2 par 0");
        try {
            reponse = LancerException.diviser(24, 4);
            reponse = LancerException.diviser(24, 0);
            reponse = LancerException.diviser(-24, 4);
            System.out.println("Division effectuée avec succès");
        } catch (ArithmeticException ae) { //L'ordre des catchs est important: Doit-être placé du plus particulier au plus général. Ici ArithmeticException hérite de RuntimeException donc ok!
            System.out.println("Erreur de division : " + ae.getMessage());
            reponse = 0;
        } catch (RuntimeException iae) {
            System.out.println("Argument invalide : " + iae.getMessage());
            reponse = 0;
        }
        finally { //ce code se fait toujours peut import s'il y a une erreur ou pas
            System.out.println("Fin du traitement de la division");
        }
        System.out.println(reponse);
    }

        //Object
        //└── Throwable
        //    ├── Exception (Doit être dans un try catch ou propagé par throws)
        //    │   ├── RuntimeException (N'ont pas besoin d'être dans des blocs try/catch et throws optonnel)
        //    │   │   ├── ArithmeticException
        //    │   │   ├── IllegalArgumentException
        //    │   │   │   └── NumberFormatException
        //    │   │   ├── NullPointerException
        //    │   │   └── IndexOutOfBoundsException
        //    │   │       └── ArrayIndexOutOfBoundsException
        //    │   └── IOException
        //    │       └── FileNotFoundException
        //    └── Error


    public void traiterDiviserAvecMulticatch() {
        int reponse;
        System.out.println("Traitement de la division de 2 par 0");
        try {
            reponse = LancerException.diviser(24, 4);
            //    reponse = LancerException.diviser(24, 0);
            reponse = LancerException.diviser(-24, 4);
            System.out.println("Division effectuée avec succès");
        } catch (ArithmeticException | NullPointerException iae) { //Les types d’exceptions dans un multicatch NE doivent PAS avoir de relation d’héritage entre eux.
            System.out.println("Argument invalide : " + iae.getMessage());
            reponse = 0;
        } catch (Exception iae) { //Les types d’exceptions dans un multicatch NE doivent PAS avoir de relation d’héritage entre eux.
            System.out.println("Argument invalide : " + iae.getMessage());
            reponse = 0;
        }
        finally { //ce code se fait toujours peut import s'il y a une erreur ou pas
            System.out.println("Fin du traitement de la division");
        }
        System.out.println(reponse);
    }


    public void demo_printStackTrace() {
        String strInt;
        int reponse;
        System.out.println("Conversion de décimal à héxadécimal");
        try {
            strInt = "24";
            reponse = LancerException.convertirStringToEntier(strInt);
            System.out.printf(strInt + " équivaut à %x en hexadécimal.%n", reponse);

            strInt = "abc";
            reponse = LancerException.convertirStringToEntier(strInt);
            System.out.printf(strInt + " équivaut à %x en hexadécimal.%n", reponse);
        } catch (RuntimeException rt) {
            System.out.println("Argument invalide : " + rt.getMessage());
            rt.printStackTrace();
            //note: printStackTrace() s’exécute bien au moment où il est appelé, mais son affichage peut apparaître à la fin à cause de la gestion des flux de sortie.
            //printStackTrace() écrit dans System.err, alors que System.out.println() écrit dans System.out.
            //Ces deux flux sont différents, tamponnés différemment, et peuvent être affichés dans un ordre inattendu.
        }
        finally { //ce code se fait toujours peut import s'il y a une erreur ou pas (optionnel)
            System.out.println("Finally");
        }
        System.out.println("Fin de la méthode: demo_printStackTrace()");
    }

    public static void main(String[] args) {
        new TraiterExceptions();
        System.out.println("Le programme se termine normalement!");
    }
}
