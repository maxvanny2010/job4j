package web.logic.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ActionTry.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/20/2020
 */
public class ActionGate extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws ServletException, IOException {
        final HttpSession session = req.getSession(false);
        session.setAttribute("infoUpload", " ");
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(req, resp);
        session.setAttribute("infoGate", " ");
    }
}
