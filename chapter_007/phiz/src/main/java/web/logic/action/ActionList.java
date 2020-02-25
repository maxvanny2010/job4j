package web.logic.action;

import web.logic.action.utils.actionutil.ActionUtil;
import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * ActionEmpty.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionList extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        final HttpSession session = req.getSession(false);
        final String role = (String) session.getAttribute("role");
        List<User> store = new ArrayList<>();
        if (Objects.equals(role, "user")) {
            final User user = (User) session.getAttribute("user");
            this.getKeeper().add(user.getId());
            store = Collections.singletonList(user);
        }
        if (Objects.equals(role, "admin")) {
            store = this.getStore().findAll();
            store.stream().mapToInt(User::getId).forEach(this.getKeeper()::add);
        }
        req.setAttribute("store", store);
        req.setAttribute("hats", ActionUtil.firstRow());
        final String path = "WEB-INF/jsp/list.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
