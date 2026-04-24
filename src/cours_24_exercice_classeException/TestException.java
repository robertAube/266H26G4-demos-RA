package cours_24_exercice_classeException;

public class TestException {
    public TestException() {
        try {
            System.out.println(convertirStringToEntier("12"));
            throw new Exception("Test");
            ///System.out.println(convertirStringToEntier("abc"));
        } catch (NumberFormatException e) {
            throw new MonRunTimeException(e); //couvertir NumberFormatException en MonRunTimeException
        } catch (Exception e ) {
            throw new MonRunTimeException(e); //couvertir Exception en MonRunTimeException
        }
    }

    public static int convertirStringToEntier(String strInt) {
        int resultat;
        resultat = Integer.parseInt(strInt);
        return resultat;
    }

    public static void main(String[] args) {
        try {
            new TestException();
        } catch (MonRunTimeException e) {
            e.printStackTrace();
        }
    }
}
