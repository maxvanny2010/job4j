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
 * ActionCleanStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/4/2020
 */
@SuppressWarnings("unused")
public class ActionClearStore extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final String id = json.get("id");
        final HttpSession session = req.getSession();
        final String role = (String) session.getAttribute("role");
        final boolean isUser = Objects.equals(role, "user");
        if (isUser && this.isId(id, this::isIdx, idxUser())) {
            final User user = (User) session.getAttribute("user");
            user.getAds().clear();
            getUser().update(user);
            setOut(resp, user);
            return;
        }
        final boolean isAdmin = Objects.equals(role, "admin");
        if (isAdmin && this.isId(id, this::isIdx, idxAdmin())) {
            getAdmin().findAllUsers().clear();
            setOut(resp, new User("ok"));
            return;
        }
        setOut(resp, new User("no"));
    }
}
