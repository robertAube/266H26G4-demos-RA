package cours_24_acces_database;

import java.sql.*;


/**
 * Démo d'une requête SQL fait à une base de données
 * TRÈS IMPORTANT :
 * mysql-connector doit être une librairie intégrée à votre projet :
 * - (répertoire racine de votre projet)\libs\mysql-connector-j-9.6.0.jar
 * - Project Structure.../Libraires/+/Java/Lier le fichier .\libs\mysql-connector-j-9.6.0.jar à votre projet.
 */
public class DatabaseManager {
    //Sécurité : on ne veut pas que ces données se retourve sur le git SURTOUT s'il est public!!!
    //On utilise des variables d'environnement pour stocker les informations d'authentification à la base de données.
    //setEnvSQL.env doit être chargé avant l'exécution java. Il est dans 'Q:/Cours/!H2026/420-266 POO2 (RA)'
    private String bdURL = System.getenv("DB_URL");
    private String bdUser = System.getenv("DB_USER");
    private String dbPassword = System.getenv("DB_PASSWORD");

    public DatabaseManager() {
        initInfoConnectionBD();
        try {
            afficherZoneWifi();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //indique que mysql-connector n'est pas correctement intégré à votre projet
            e.printStackTrace();
        }
    }

    private void initInfoConnectionBD() {
        bdURL = System.getenv("DB_URL");
        bdUser = System.getenv("DB_USER");
        dbPassword = null; //System.getenv("DB_PASSWORD");

        if (bdURL == null || bdUser == null || dbPassword == null) {
            System.out.println("ERREUR : DB_URL, DB_USER et DB_PASSWORD doivent-être initialisés.");
            System.out.println("Les variables d'environnement DB_URL, DB_USER et DB_PASSWORD sont utilisées pour stocker les informations d'authentification à la base de données.");
            System.out.println("Ils doivent être initialisées AVANT que java démarre.");
            System.out.println("Dans IntelliJ, allez dans le menu sélectionner : 'Run' / 'Run...' / 'Edit Configuration...'");
            System.out.println("Dans 'Environment variables', charger le fichier disponible sur 'Q:/Cours/!H2026/420-266 POO2 (RA)/setEnvSQL.env'");
            System.out.println("Raison: On ne veut pas retouver les informations d'authentification sur un GIT public.");
            System.out.println("        C'est une question de sécurité.");
            System.exit(1); //Termine le programme avec un code d'erreur (1) pour indiquer qu'il y a eu une erreur. Ici, l'initialisation des variables d'environnement.
        }
    }

    public void afficherZoneWifi() throws ClassNotFoundException, SQLException {
        Connection conn;
        String sql = "SELECT id, arrondissement, municipalite, nom_lieu, longitude, latitude FROM bd_poo266.zone_wifi;";


        Class.forName("com.mysql.cj.jdbc.Driver"); //Lance une ClassNotFoundException si le driver mysql-connector n'est pas correctement intégré à votre projet.
        conn = DriverManager.getConnection(bdURL, bdUser, dbPassword); //Établit une connexion entre le programme Java et la base de données
        Statement stmt = conn.createStatement(); //stmt outil pour envoyer des requêtes SQL à la base de données
        ResultSet rs = stmt.executeQuery(sql); //rs contient une table virtuelle du sql exécuté (ici le SELECT) - Curseur placé avant la première ligne


        while (rs.next()) { //rs.next() fait avancer le curseur d'une ligne et retourne false si on dépasse la dernière ligne
            System.out.println("id : " + rs.getString("id") +
                    " | arrondissement : " + rs.getString("arrondissement") +
                    " | municipalite : " + rs.getString("municipalite") +
                    " | nom_lieu : " + rs.getString("nom_lieu") +
                    " | longitude : " + rs.getDouble("longitude") +
                    " | Latitude : " + rs.getDouble("latitude"));
        }
    }

    public static void main(String[] args) {
        new DatabaseManager();
    }
}
