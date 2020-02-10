package web.logic.exception;

/**
 * ActionException.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/1/2020
 */
public class ActionIllegalException extends IllegalAccessException {
    /**
     * Exception when to call not correct a action.
     *
     * @param msg a message
     */
    public ActionIllegalException(final String msg) {
        super(msg);
    }
}
