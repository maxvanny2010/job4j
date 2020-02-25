package web.logic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ActionLogOut.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/23/2020
 */
public class ActionLogOut extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        session.invalidate();
        resp.sendRedirect("/gate");
    }
}
