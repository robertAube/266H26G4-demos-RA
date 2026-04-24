package cours_07_interface_heritage_abstraction;

public abstract class Quadrilatere extends Forme {
    public Quadrilatere(String nomForme) {
        super(nomForme);
    }

    @Override
    public String getInfo() {
        Integer i;
        String str;
        str = super.getInfo();
        str += "Je suis un quadrilatère\n";

        return str;
    }
}
