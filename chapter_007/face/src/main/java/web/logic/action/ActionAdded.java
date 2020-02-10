package web.logic.action;

import web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ActionAdd.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionAdded extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String email = req.getParameter("email");
        final User user = new User(name, login, email);
        this.getStore().add(user);
        resp.sendRedirect("/index");
    }
}
