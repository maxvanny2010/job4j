package ua.autos.logic.action;

import ua.autos.model.ads.Ads;
import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionViewAds.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/24/2020
 */
public class ActionViewAds extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws Exception {
        req.setCharacterEncoding("UTF-8");
        final String id = json.get("id");
        final Map<String, Object> outs = this.getJSON(id, req);
        setOut(resp, outs);
    }

    /**
     * Method to get json for answer.
     *
     * @param id  a id
     * @param req a request
     * @return a map of answers
     */
    private Map<String, Object> getJSON(final String id,
                                        final HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (Objects.equals(session, null)) {
            session = req.getSession();
            session.setAttribute("role", "unknown");
            session.setAttribute("user", new User("unknown"));
        }
        final User user = (User) session.getAttribute("user");
        final Map<String, Object> answers = new HashMap<>();
        answers.put("role", user);
        answers.put("ads", new User("no"));
        if (this.isInt(id)) {
            final int idx = Integer.parseInt(id);
            final Ads ads = getAds().getById(idx);
            final Optional<User> phone = getUser().getUserIdByAds(ads);
            phone.ifPresent(u -> answers.put("phone", u.getPhone()));
            answers.put("ads", ads);
            return answers;
        }
        return answers;
    }
}
