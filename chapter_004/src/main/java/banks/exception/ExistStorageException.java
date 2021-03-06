package banks.exception;

/**
 * LimitMoneyOfAccountException.
 *
 * @author Maxim Vanny.
 * @version 4.0
 * @since 0.1
 */
public class ExistStorageException extends Exception {
    /**
     * Constructor.
     *
     * @param message message for user
     */
    public ExistStorageException(final String message) {
        super(message);
    }
}
