package ua.nino.logic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionException.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/25/2020
 */
public class ActionException extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        setOut(resp, "exception");
    }
}
