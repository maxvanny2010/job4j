package ua.nino.logic.action;

import ua.nino.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionViewUser.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
@SuppressWarnings("unused")
public class ActionViewUser extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws Exception {
        req.setCharacterEncoding("UTF-8");
        final String id = json.get("id");
        User user = this.getJSON(id, req);
        setOut(resp, user);
    }

    /**
     * Method to get json for answer.
     *
     * @param id  a id
     * @param req a request
     * @return json
     */
    private User getJSON(final String id, final HttpServletRequest req) {
        final HttpSession session = req.getSession(false);
        if (this.isId(id, this::isIdx, idxUser())) {
            final int idx = Integer.parseInt(id);
            return getUser().getById(idx);
        }
        return new User("no");
    }
}
