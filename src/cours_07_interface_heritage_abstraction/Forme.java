package cours_07_interface_heritage_abstraction;

public abstract class  Forme {
    protected String nomForme;

    public Forme(String nomForme) {
        this.nomForme = nomForme;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    abstract double getAire();
    abstract String getDimensions();

    public String getInfo() {
        String str;

        str = "Nom de la forme : " + nomForme + "\n";
        str += getDimensions() + "\n";
        str += "Son air est de : " + getAire() + "\n";

        if (this instanceof CymetrieCentrale) {
            str+= "Cette forme a une symétrie centrale\n";;
        }

        return str;
    }
}
