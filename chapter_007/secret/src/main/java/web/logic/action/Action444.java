package web.logic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Action444.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/23/2020
 */
public class Action444 extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        final Object user = session.getAttribute("user");
        if (user != null) {
            resp.sendRedirect("/list");
            return;
        }
        resp.sendRedirect("/gate");
    }
}
