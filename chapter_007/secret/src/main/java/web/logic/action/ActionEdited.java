package web.logic.action;

import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * ActionEdited.
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
        req.setCharacterEncoding("UTF-8");
        final HttpSession session = req.getSession(false);
        final String id = req.getParameter("id");
        final String login = req.getParameter("login");
        this.userToSetInSession(id, session, resp);
        final User user = (User) session.getAttribute("user");
        final boolean isLogin = ActionAbs.getStore().isLogin(login);
        final boolean isLoginEq = Objects.equals(login, user.getLogin());
        if (isLogin && !isLoginEq) {
            session.setAttribute("infoEdit", "Логин занят.");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp")
                    .forward(req, resp);
            return;
        }
        final String name = req.getParameter("name");
        final String email = req.getParameter("email");
        user.setName(name);
        user.setEmail(email);
        user.setLogin(login);
        ActionAbs.getStore().update(user);
        resp.sendRedirect("/list");
    }
}
