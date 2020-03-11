package web.logic.exception;

/**
 * StoreExistException.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/13/2020
 */
public class StoreExistException extends StoreException {
    /**
     * Constructor.
     *
     * @param id a id
     */
    public StoreExistException(final int id) {
        super("User " + id + " already exist");
    }
}
