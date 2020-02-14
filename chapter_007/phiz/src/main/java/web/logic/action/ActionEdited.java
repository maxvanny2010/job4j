package web.logic.action;

import web.logic.action.utils.actionutil.ActionUtil;
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
        final User user = this.getStore().findById(Integer.parseInt(id));
        final boolean check = ActionUtil.isParameters(req);
        if (!check) {
            req.setAttribute("fall", "ok");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp")
                    .forward(req, resp);
        } else {
            final String name = req.getParameter("name");
            final String login = req.getParameter("login");
            final String email = req.getParameter("email");
            user.setName(name);
            user.setLogin(login);
            user.setEmail(email);
            this.getStore().update(user);
            resp.sendRedirect("/index");
        }
    }
}
