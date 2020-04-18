package ua.autos.logic.action;

import ua.autos.logic.action.utils.actionutil.SearchesUtil;
import ua.autos.model.ads.Ads;
import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionSearches.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/13/2020
 */
public class ActionSearches extends ActionAbs {

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        final String brand = SearchesUtil.getBrand(json.get("brand"));
        final String model = SearchesUtil.getModel(brand, json.get("model"));
        final String engine = SearchesUtil.getEngine(json.get("engine"));
        final String year = SearchesUtil.getYear(json.get("year"));
        final String color = SearchesUtil.getColor(json.get("color"));
        if (Objects.equals(session, null)) {
            session = req.getSession();
            session.setAttribute("role", "unknown");
            session.setAttribute("user", new User("unknown"));
        }
        final List<Integer> autoId = getAuto().findAutoId(
                brand, model, engine, year, color);
        final List<Ads> list = new ArrayList<>();
        autoId.forEach(id -> list.add(getAds().findAdsByIdAuto(id)));
        final HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        setOut(resp, map);
    }
}
