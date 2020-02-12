package web.logic.action;

import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ActionUpdate.
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
        final String id = req.getParameter("id");
        final String fall = req.getParameter("fall");
        final User user = this.getStore().findById(Integer.parseInt(id));
        req.setAttribute("user", user);
        req.setAttribute("fall", "no");
        if (fall != null) {
            req.setAttribute("fall", "ok");
        }
        req.getRequestDispatcher("WEB-INF/jsp/edit.jsp")
                .forward(req, resp);
    }
}
