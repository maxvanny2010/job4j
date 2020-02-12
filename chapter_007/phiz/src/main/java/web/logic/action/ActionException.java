package web.logic.action;

import web.logic.exception.ActionIllegalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ActionException.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/1/2020
 */
public class ActionException extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp) {
        try {
            throw new ActionIllegalException("access not defined");
        } catch (ActionIllegalException e) {
            e.printStackTrace();
        }
    }
}
