package cours_24_exercice_classeException;

public class MonRunTimeException extends RuntimeException {

    /**
     * Construit une exception sans message détaillé.
     */
    public MonRunTimeException() {
        super();
    }

    /**
     * Construit une exception avec un message descriptif.
     *
     * @param message le message détaillant la cause de l'exception
     */
    public MonRunTimeException(String message) {
        super(message);
    }

    /**
     * Construit une exception à partir d'une {@link RuntimeException}
     * existante.
     *
     * @param e l'exception d'origine à encapsuler
     */
    public MonRunTimeException(Exception e) {
        super(e);
    }
}
