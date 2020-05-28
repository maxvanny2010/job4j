package ua.nino.logic.action;

import ua.nino.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionEditUser.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/10/2020
 */
@SuppressWarnings("unused")
class ActionEditUser extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws Exception {
        req.setCharacterEncoding("UTF-8");
        final String id = json.get("id");
        String outs = this.getJSON(id, req, json);
        setOut(resp, outs);
    }

    /**
     * Method to get json for answer.
     *
     * @param id   a id
     * @param req  a request
     * @param json a json
     * @return json
     */
    private String getJSON(final String id, final HttpServletRequest req,
                           final HashMap<String, String> json) {
        final HttpSession session = req.getSession(false);
        if (this.isId(id, this::isIdx, idxUser())) {
            final int idx = Integer.parseInt(id);
            final String email = json.get("email");
            User user = getUser().getById(idx);
            user.setEmail(email);
            getUser().update(user);
            session.setAttribute("user", user);
            return "ok";
        }
        return "no";
    }
}
