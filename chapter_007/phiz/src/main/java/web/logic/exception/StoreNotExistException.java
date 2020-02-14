package web.logic.exception;

/**
 * StoreNotExistException.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/13/2020
 */
public class StoreNotExistException extends StoreException {
    /**
     * Constructor.
     *
     * @param id a id
     */
    public StoreNotExistException(final int id) {
        super("User" + id + "not exist");
    }
}
