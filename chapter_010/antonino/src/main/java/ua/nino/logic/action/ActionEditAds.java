package ua.nino.logic.action;

import ua.nino.model.ads.Ads;
import ua.nino.model.ads.Status;
import ua.nino.model.auto.Auto;
import ua.nino.model.auto.Colors;
import ua.nino.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionEditAds.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/10/2020
 */
public class ActionEditAds extends ActionAbs {
    /**
     * field a colors.
     */
    private static final Map<String, String> COLORS = new HashMap<>() {{
        put("1", "чёрный");
        put("2", "синий");
        put("3", "белый");
        put("4", "зелёный");
        put("5", "серый");
    }};

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws Exception {
        req.setCharacterEncoding("UTF-8");
        final String id = json.get("id");
        User user = this.getJSON(id, json, req);
        setOut(resp, user);
    }

    /**
     * Method to get json for answer.
     *
     * @param id   a id
     * @param json a json
     * @param req  a request
     * @return json
     */
    private User getJSON(final String id,
                         final HashMap<String, String> json,
                         final HttpServletRequest req) {
        if (this.isId(id, this::isIdx, idxAds())) {
            final int idx = Integer.parseInt(id);
            final Ads ads = getAds().getById(idx);
            final String status = json.get("status");
            final boolean isYes = Objects.equals(status, "1");
            final boolean isNo = Objects.equals(status, "2");
            if (!status.isEmpty()) {
                if (isYes) {
                    ads.setStatus(Status.YES.getStatus());
                } else if (isNo) {
                    ads.setStatus(Status.NO.getStatus());
                }
            }
            final String color = json.get("color");
            final String getColor = COLORS.getOrDefault(color, "");
            if (!getColor.isEmpty()) {
                List<?> list = getAuto().findByValue(getColor, Colors.class);
                final Colors value = (Colors) list.get(0);
                final int idu = ads.getAuto().getId();
                final Auto auto = getAuto().getById(idu);
                auto.setColor(value);
                ads.setAuto(auto);
            }
            final HttpSession session = req.getSession(false);
            final User user = (User) session.getAttribute("user");
            getAds().update(ads);
            final User update = getUser().getById(user.getId());
            update.getAds().add(ads);
            getUser().update(update);
            session.setAttribute("user", update);
            return update;
        }
        return new User("no");
    }

}
