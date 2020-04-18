package ua.autos.logic.action;

import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionLogOut.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/23/2020
 */
public class ActionLogOut extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        session.setAttribute("user", new User("unknown"));
        session.setAttribute("role", "unknown");
        setOut(resp, new User("no"));
        session.invalidate();
    }
}
