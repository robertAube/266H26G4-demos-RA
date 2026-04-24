package solutionsFormatifs.Formatif4_sol.Formatif4_P2;

/**
 * Classe représentant un joueur avec nom, gain et couleur.
 */
public class Joueur {
    /**
     * Longueur minimum d'un nom de joueur
     */
    public static final int LONGUEUR_NOM_MIN = 3;

    /**
     * Longueur maximum d'un nom de joueur
     */
    public static final int LONGUEUR_NOM_MAX = 15;

    /**
     * Le nom du joueur
     */
    private String nom = "";

    /**
     * La couleur du joueur
     */
    private char couleur = ' ';

    /**
     * Constructeur avec paramètres nom, couleur et gain.
     *
     * @param nom     le nom du joueur
     * @param couleur la couleur du joueur
     */
    public Joueur(String nom, char couleur) {
			setNom(nom);
			setCouleur(couleur);
    }

    /**
     * Obtenir le nom du joueur
     *
     * @return String, le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom du joueur.
     *
     * @param nom le nouveau nom du joueur
     * @return boolean, vrai si le nom a été modifié
     */
    public void setNom(String nom) {
        if (!validerNom(nom))
            throw new RuntimeException("Nom invalide: " + nom);

            this.nom = nom;
    }

    /**
     * Valider le nom du joueur (n'est pas null et possède une longueur valide)
     *
     * @param pNom le nom à valider
     * @return boolean, vrai si le nom est valide
     */
    public static boolean validerNom(String pNom) {
        return ((pNom != null) && (pNom.length() >= Joueur.LONGUEUR_NOM_MIN) &&
                (pNom.length() <= Joueur.LONGUEUR_NOM_MAX));
    }


    /**
     * Obtenir la couleur du joueur
     *
     * @return Color, la couleur du joueur
     */
    public char getCouleur() {
        return couleur;
    }

    /**
     * Modifier la valeur de la couleur du joueur
     *
     * @param couleur la nouvelle couleur
     * @return boolean, vrai si la couleur a été modifiée
     */
    public void setCouleur(char couleur) {
        assert Joueur.validerCouleur(couleur) : "couleur invalide";
        this.couleur = couleur;
    }

    /**
     * Valider la couleur du joueur
     *
     * @param pCouleur la couleur à valider
     * @return boolean, vrai si le pointeur de l'objet n'est pas nul
     */
    public static boolean validerCouleur(char pCouleur) {
        return (pCouleur != ' ');
    }


    /**
     * Construit une chaîne de caractères représentant l'état de l'objet Joueur
     *
     * @return String, la chaîne construite contenant nom et et gains
     */
    public String toString() {
        return this.getNom() + ": ";
    }


}
