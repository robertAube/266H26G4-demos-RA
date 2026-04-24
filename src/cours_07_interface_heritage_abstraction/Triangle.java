package cours_07_interface_heritage_abstraction;

public class Triangle extends Forme {
    private double base;
    private double hauteur;

    public Triangle(double base, double hauteur) {
        super("Triangle");
        this.base = base;
        this.hauteur = hauteur;
    }

    public double getAire() {
        double aire;

        aire= base *hauteur / 2;

        return aire;
    }

    @Override
    String getDimensions() {
        String str;
        str = "base = " + base;
        str += " hatueur = " + hauteur;
        return str;
    }
}
