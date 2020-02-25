package web.logic.action;

import web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * ActionDelete.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionDelete extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        final String id = req.getParameter("id");
        this.userToSetInSession(id, session, resp);
        final User user = (User) session.getAttribute("user");
        this.getStore().delete(user);
        final String role = (String) session.getAttribute("role");
        if (Objects.equals(role, "user")) {
            session.removeAttribute("role");
            session.removeAttribute("user");
            this.getKeeper().clear();
            resp.sendRedirect("/gate");
            return;
        }
        resp.sendRedirect("/list");
    }
}
