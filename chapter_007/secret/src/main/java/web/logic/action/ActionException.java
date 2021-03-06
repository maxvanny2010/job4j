package web.logic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
                              final HttpServletResponse resp)
            throws IOException {
        resp.sendRedirect("/404");
    }
}
