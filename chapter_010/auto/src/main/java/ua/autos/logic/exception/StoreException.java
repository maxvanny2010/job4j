package ua.autos.logic.exception;

/**
 * StoreException.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/13/2020
 */
public class StoreException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param message a message
     */
    public StoreException(final String message) {
        super(message);
    }
}
