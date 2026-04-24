package cours_11b_Comparable_sort;

/**
 * @author Robert Aubé
 * @version 1.0
 */
public class TestComparable {
    public TestComparable() {
        testerComparable("aaaa", "bbbb");
        testerComparable("bbbb", "bbbb");
        testerComparable("bbb", "bbbb");
        testerComparable("bbc", "bbbb");
        testerComparable("cccc", "bbbb");
        testerComparable("cccc", "ccCc"); //case sensitive
        testerComparable(new Pizza(1,1,"mauve", 3), new Pizza(1,1,"mauve", 3));
        testerComparable(new Pizza(1,1,"mauve", 3), new Pizza(1,1,"mauve", 2));
        testerComparable(new Pizza(1,1,"mauve", 3), new Pizza(1,1,"mauve", 4));
    }

    /**
     * Tester si la méthode compareTo fonctionne
     * @param v1
     * @param v2
     */
    public static void testerComparable(Comparable v1, Comparable v2) {
        int comparation = v1.compareTo(v2);
        if (comparation == 0) {
            System.out.println(v1 + " = " + v2);
        } else if (comparation < 0) {
            System.out.println(v1 + " < " + v2);
        } else {
            System.out.println(v1 + " > " + v2);
        }
    }


    public static void main(String[] args) {
        new TestComparable();
    }
}
