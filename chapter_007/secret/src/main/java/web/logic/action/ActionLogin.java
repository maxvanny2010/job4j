package web.logic.action;

import web.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ActionLogin.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/20/2020
 */
public class ActionLogin extends ActionAbs {
    /**
     * field a file admin properties.
     */
    public static final String FILE = "admin.properties";

    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        final HttpSession session = req.getSession(false);
        final String roles = req.getParameter("role");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        Role.factoryRoles(roles).apply(login, password, session);
        resp.sendRedirect("/list");
    }
}

