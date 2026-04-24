package cours_08_equals;

public class Coordonnee {
    private int x;
    private int y;

    public static final int X_DEFAUT = 0;
    public static final int Y_DEFAUT = 0;

    public static final int MIN_XY = Integer.MIN_VALUE;
    public static final int MAX_XY = Integer.MAX_VALUE;


    public Coordonnee() {
        this(X_DEFAUT, Y_DEFAUT);
    }

    public Coordonnee(int x, int y) {
        move(x, y);
    }

    public void move(int x, int y) {
        if (xyEstValide(x, y)) {
            this.x = x;
            this.y = y;
        } else {
            throw new IllegalArgumentException("x = " + x + " et y = " + y + " est invalide comme coordonnées");
        }
    }

    public void translate(int dX, int dY) {
        move(x + dX, y + dY);
    }


    public static boolean xyEstValide(int x, int y) {
        boolean estValide;
        estValide = MIN_XY <= x && x <= MAX_XY;
        estValide &= MIN_XY <= y && y <= MAX_XY;
        return estValide;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false; // si je compare avec un objet qui n'existe pas, c'Est évidemment faux
        if (this == object) // vérifie si c'Est le même objet
            return true;
        if (getClass() != object.getClass())
            return false; //on vérifie si les types sont compatibles
//rendu ici, on est certain d'avoir une coordonnées
        Coordonnee that = (Coordonnee) object;
        return x == ((Coordonnee)object).x && y == that.y;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}