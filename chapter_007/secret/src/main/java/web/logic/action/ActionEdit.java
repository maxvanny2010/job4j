package web.logic.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ActionEdit.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionEdit extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            final String id = req.getParameter("id");
            this.setUserInRequest(id, req);
        } catch (RuntimeException e) {
            System.out.println("Access is define");
            resp.sendRedirect("/404");
            return;
        }
        final HttpSession session = req.getSession(false);
        session.setAttribute("infoEdit", " ");
        final String path = "WEB-INF/jsp/edit.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
