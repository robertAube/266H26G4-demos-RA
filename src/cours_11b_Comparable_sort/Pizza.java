package cours_11b_Comparable_sort;
/**
 * @author Robert Aubé
 * @version 1.0
 */
public class Pizza implements Comparable<Pizza> { //Comparable<T> = “interface pour comparer des objets de type T”.
//    public class Pizza  { //Comparable<T> = “interface pour comparer des objets de type T”.
    public static final int VITESSE_MIN = 0;
    public static final int VITESSE_MAX = 50;

    // vitesse est entre 0 et 50

    //attributs ou variables d'instance
    //N'existe pas sans instanciation
    private Coordonnee position;

    private int vitesse;
    private String couleur;

    Pizza(int x, int y, String couleur, int vitesse) {
        position = new Coordonnee(x, y);
        this.couleur = couleur;
        setVitesse(vitesse);
    }

    //mutateur
    public void setVitesse(int vitesse) {
        if (estValideVitesse(vitesse)) {
            this.vitesse = vitesse;
        } else {
            throw new RuntimeException("Vitesse " + vitesse + " est invalide.");
        }
    }

    public static boolean estValideVitesse(int vitesse) {
        return VITESSE_MIN <= vitesse && vitesse <= VITESSE_MAX;
    }

    //accesseur
    public int getX() {
        return position.getX();
    }

    //accesseur
    public int getY() {
        return position.getY();
    }

    //accesseur
    public int getVitesse() {
        return vitesse;
    }

    //accesseur
    public String getCouleur() {
        return couleur;
    }

    //Surcharge : 2 méthodes avec le même nom, mais des arguments différents. On dira aussi que la signature est différente.
    public void setXY(int x, int y) {
        position.move(x, y);
    }

    public void setXY(Coordonnee newPosition) {
        if (newPosition != null) {
            position = newPosition;
        } else {
            throw new NullPointerException("La coordonnée n'est pas une instance");
        }
    }

    public static boolean estValideXY(int x, int y) {
        boolean estV;
        estV = Coordonnee.estValideX(x) && Coordonnee.estValideY(y);

        return estV;
    }

    public void avancerX() {
        position.translate(vitesse, 0);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "x=" + position.getX() +
                ", y=" + position.getY() +
                ", vitesse=" + vitesse +
                ", couleur='" + couleur + '\'' +
                '}';
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (vitesse != pizza.vitesse) return false;
        if (position != null ? !position.equals(pizza.position) : pizza.position != null) return false;
        return couleur != null ? couleur.equalsIgnoreCase(pizza.couleur) : pizza.couleur == null;
    }

    /**
     * comparer avec la couleur
     * @param pizza the object to be compared.
     * @return
     */
//    @Override
//    public int compareTo(Pizza pizza) {
//        return this.couleur.compareTo(pizza.couleur);
//    }

    /**
     * Comparer avec la vitesse
     * @param pizza the object to be compared.
     * @return
     */
//    @Override
    public int compareTo(Pizza pizza) {

        int difference = vitesse - pizza.vitesse;
//        int difference = pizza.vitesse - vitesse; // pas bon
        Integer i;
        return difference;
        //a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
        // si retour = 0 -> égale
        // si retour < 0 -> objet courant est plus petit que l'objet reçu en argument.
        // si retour > 0 -> objet courant est plus grand que l'objet reçu en argument.
    }
}
