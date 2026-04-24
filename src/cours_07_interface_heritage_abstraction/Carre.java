package cours_07_interface_heritage_abstraction;

public class Carre extends Quadrilatere implements CymetrieCentrale {
    private double dimension;

    public Carre(double dimension) {
        super("Carré");
        this.dimension = dimension;
    }

    public double getAire() {
        double aire;

        aire= dimension * dimension;

        return aire;
    }

    @Override
    String getDimensions() {
        return "coté = " + dimension;
    }
}
