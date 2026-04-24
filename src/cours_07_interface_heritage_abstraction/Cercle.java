package cours_07_interface_heritage_abstraction;

public class Cercle extends Forme implements CymetrieCentrale {
    private double rayon;

    public Cercle(double rayon) {
        super("Cercle");
//        nomForme = "MonCercle";
        this.rayon = rayon;
    }

    public double getAire() {
        double aire;


        aire= Math.PI * Math.pow(rayon, 2);

        return aire;
    }

    @Override
    String getDimensions() {
        return "rayon = " + rayon;
    }
}
