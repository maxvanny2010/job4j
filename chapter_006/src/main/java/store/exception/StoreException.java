package store.exception;

/**
 * StoreException.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/26/2019
 */
public class StoreException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param msg message
     */
    public StoreException(final String msg) {
        super(msg);
    }
}
