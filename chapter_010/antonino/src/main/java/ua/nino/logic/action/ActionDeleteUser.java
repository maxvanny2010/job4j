package ua.nino.logic.action;

import ua.nino.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionDeleteUser.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionDeleteUser extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        final String role = (String) session.getAttribute("role");
        final String id = json.get("id");
        final boolean isUser = Objects.equals(role, "user");
        if (isUser && this.isId(id, this::isIdx, idxUser())) {
            final User user = (User) session.getAttribute("user");
            getUser().delete(user);
            session.removeAttribute("role");
            session.removeAttribute("user");
            idxUser().clear();
            idxAds().clear();
            idxAdmin().removeIf(v -> Objects.equals(user.getId(), v));
            setOut(resp, new User("ok"));
            return;
        }
        final boolean isAdmin = Objects.equals(role, "admin");
        if (isAdmin && this.isId(id, this::isIdx, idxAdmin())) {
            final User user = getAdmin().getById(Integer.parseInt(id));
            getAdmin().delete(user);
            idxAdmin().removeIf(v -> Objects.equals(user.getId(), v));
            setOut(resp, new User("ok"));
            return;
        }
        setOut(resp, new User("no"));
    }
}
