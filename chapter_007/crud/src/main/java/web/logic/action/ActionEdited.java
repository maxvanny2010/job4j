package web.logic.action;

import web.logic.action.utils.Utils;
import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ActionUpdated.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/31/2020
 */
public class ActionEdited extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = req.getParameter("id");
        final boolean check = Utils.isParameters(req);
        if (!check) {
            final String path = "/index?action=edit&fall=ok&id=" + id;
            req.getRequestDispatcher(path).forward(req, resp);
        } else {
            final String name = req.getParameter("name");
            final String login = req.getParameter("login");
            final String email = req.getParameter("email");
            final User user = this.getStore().findById(Integer.parseInt(id));
            user.setName(name);
            user.setLogin(login);
            user.setEmail(email);
            this.getStore().update(user);
            resp.sendRedirect("/index");
        }
    }
}
