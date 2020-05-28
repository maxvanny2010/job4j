package ua.nino.logic.action;

import ua.nino.logic.action.utils.actionutil.SearchesUtil;
import ua.nino.model.ads.Ads;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

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
        final String brand = SearchesUtil.getBrand(json.get("brand"));
        final String model = SearchesUtil.getModel(brand, json.get("model"));
        final String engine = SearchesUtil.getEngine(json.get("engine"));
        final String year = SearchesUtil.getYear(json.get("year"));
        final String color = SearchesUtil.getColor(json.get("color"));
        final List<Integer> autoId = getAuto().findAutoId(
                brand, model, engine, year, color);
        final List<Ads> list = new ArrayList<>();
        autoId.forEach(id -> list.add(getAds().findAdsByIdAuto(id)));
        final HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        setOut(resp, map);
    }
}
