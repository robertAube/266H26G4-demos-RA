package cours_17b_exception;
/**
 * Exception personnalisée signalant qu'un argument fourni à une méthode
 * est invalide.
 */
public class MonIllegalArgumentException extends IllegalArgumentException {

    /**
     * Construit une exception sans message détaillé.
     */
    public MonIllegalArgumentException() {
        super();
    }

    /**
     * Construit une exception avec un message descriptif.
     *
     * @param message le message détaillant la cause de l'exception
     */
    public MonIllegalArgumentException(String message) {
        super(message);
    }

    /**
     * Construit une exception à partir d'une {@link IllegalArgumentException}
     * existante.
     *
     * @param e l'exception d'origine à encapsuler
     */
    public MonIllegalArgumentException(IllegalArgumentException e) {
        super(e);
    }
}