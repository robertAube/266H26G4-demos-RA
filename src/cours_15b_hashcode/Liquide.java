package cours_15b_hashcode;
import java.util.Objects;

/**
 * Hashcode d’une classe
 */
public class Liquide implements Comparable<Liquide> //Type générique
{
    private String nom; //lait (1030), eau (1000), essence (750), Mercure(13600)
    private int masseVolumique_KgParM3;

    public Liquide(String nom, int masseVolumique_KgParM3) {
        setNom(nom);
        this.masseVolumique_KgParM3 = masseVolumique_KgParM3;
    }
    public void setNom(String nom) {
        if (validerNom(nom))
            this.nom = nom;
        else
            throw new RuntimeException("Le nom ne peut pas être null");
    }
    public static boolean validerNom(String nom) {
        return (nom != null);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Liquide liquide = (Liquide) o;

        return Objects.equals(nom, liquide.nom);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nom);
        sb.append( " - { masseVolumique= " + masseVolumique_KgParM3 + " Kg/M3");
        sb.append(", hashCode= " + this.hashCode());
        sb.append(" (" + String.format("0x%08X", this.hashCode())+ ") }");

        return sb.toString();
    }
    @Override
    public int compareTo(Liquide liquide) {
        return liquide.nom.compareTo(liquide.nom);
    }
    public static void main(String[] args) {
        Liquide [] lLiquide = {
                new Liquide("huile de sésame", 920),
                new Liquide("huile de sésam", 920),
                new Liquide("eau", 999),
                new Liquide("eau", 1000),
                new Liquide("mercure", 13600),
                new Liquide("mercure", 13600),
        };
        for (Liquide liquide: lLiquide) {
            System.out.println(liquide);
        }
    }
}
