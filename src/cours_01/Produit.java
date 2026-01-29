package cours_01;

public class Produit {
    public static final String NOM_DEF = "";
    public static final double PRIX_DEF = 0;
    public static final int QTE_DEF = 0;

    private static int cptNo = 1000;

    private int no;
    private String nom;
    private double prix;
    private int qte;

    public Produit() {
        this(NOM_DEF, PRIX_DEF, QTE_DEF);
    }

    //surcharge
    public Produit(String nom, double prix, int qte) {
        this.no = cptNo++;
        this.nom = nom;
        this.prix = prix;
        this.qte = qte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        //menu/run/Edit Configurations.../Modify Options/Add VM options/Dans "VM options" ajouter -ea
        assert validerPrix(prix) : "Un prix ne peut pas être négatif"; // lance une exception avec le message correspondant
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public static boolean validerPrix(double prix) {
        boolean estValide = prix >= 0;
        return estValide;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;
        return no == produit.no;
    }

    @Override
    public int hashCode() {
        return no;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "no=" + no +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", qte=" + qte +
                '}';
    }

    public void setNo(int no) {
        this.no = no;
    }
}
