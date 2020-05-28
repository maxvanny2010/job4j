package ua.nino.logic.action;

import ua.nino.model.ads.Ads;
import ua.nino.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionDeleteAds.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/25/2020
 */
public class ActionDeleteAds extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        final String role = (String) session.getAttribute("role");
        final String id = json.get("id");
        final String idU = json.get("idU");
        final String roles = json.get("role");
        final boolean isUser = Objects.equals(role, "user");
        final boolean isRoleUser = Objects.equals(role, roles);
        if (isUser && isRoleUser && this.isId(idU, this::isIdx, idxUser())) {
            final int idx = Integer.parseInt(idU);
            final int ida = Integer.parseInt(id);
            final Ads byId = getAds().getById(ida);
            getAds().delete(byId);
            final User user = getUser().getById(idx);
            user.getAds().removeIf(v -> v.getId() == ida);
            idxAds().removeIf(v -> v == ida);
            getUser().update(user);
            session.setAttribute("user", user);
            setOut(resp, new User("ok"));
            return;
        }
        final boolean isAdmin = Objects.equals(role, "admin");
        final boolean checkUserId = this.isId(idU, this::isIdx, idxAdmin());
        final boolean checkAdsId = this.isInt(id);
        if (isAdmin && isRoleUser && checkAdsId && checkUserId) {
            final int idx = Integer.parseInt(idU);
            final int ida = Integer.parseInt(id);
            final Ads byId = getAds().getById(ida);
            getAds().delete(byId);
            final User user = getAdmin().getById(idx);
            user.getAds().removeIf(v -> v.getId() == ida);
            getAdmin().update(user);
            setOut(resp, new User("ok"));
            return;
        }
        setOut(resp, new User("no"));
    }
}
