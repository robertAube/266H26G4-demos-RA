package cours_09_tableau2D;

public class tableau2D {
    public tableau2D() {
        // revoirTableau1D();
//        travaillerAvecTableau2D_v1();
//        travaillerAvecTableau2D_v2();
        travaillerAvecTableau2D_v3();
    }

    private void travaillerAvecTableau2D_v1() {
        int[][] tab2D = {{1, 2, 3}, {3, 2, 1}, {1, 1, 1}};

        for (int ligne = 0; ligne < tab2D.length; ligne++) {
            for (int colonne = 0; colonne < tab2D[ligne].length; colonne++) {
                System.out.print(tab2D[ligne][colonne] + ", ");
            }
            System.out.println();
        }
    }

    private void travaillerAvecTableau2D_v2() {
        int[][] tab2D = {{1, 2, 3}, {3, 2, 1}, {1, 1, 1}};

        for (int ligne = 0; ligne < tab2D.length; ligne++) {
            afficherTableau(tab2D[ligne]);
            System.out.println();
        }
    }

    private void travaillerAvecTableau2D_v3() {
//        int[][] tab2D = {{1, 2, 3}, {3, 2, 1}, {1, 1, 1}};
        int[][] tab2D = {{1, 2, 3}, {}, {1}};

        afficherTableau(tab2D);
    }

    private void afficherTableau(int[][] tab2D) {
        for (int ligne = 0; ligne < tab2D.length; ligne++) {
            afficherTableau(tab2D[ligne]);
            System.out.println();
        }
    }

    private void revoirTableau1D() {
        int[] tab1D = {1, 4, 2};

        afficherTableau(tab1D);
    }

    public void afficherTableau(int[] tableau) {
        String str;
        str = "{";
        for (int i = 0; i < tableau.length; i++) {
            str += tableau[i] + (i + 1 == tableau.length ? "" : ", ");
        }
        System.out.print(str + '}');
    }

    public static void main(String[] args) {
        new tableau2D();
    }
}
