package web.logic.action;

import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ActionView.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/31/2020
 */
public class ActionView extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws ServletException, IOException {
        final User user = this.getUserIdByRequest(req);
        req.setAttribute("user", user);
        final String path = "/WEB-INF/jsp/view.jsp";
        req.getServletContext().getRequestDispatcher(path).forward(req, resp);
    }
}
