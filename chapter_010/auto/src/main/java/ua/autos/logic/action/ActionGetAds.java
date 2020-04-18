package ua.autos.logic.action;

import ua.autos.model.ads.Ads;
import ua.autos.model.ads.Foto;
import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionIndex.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/2/2020
 */
public class ActionGetAds extends ActionAbs {

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        final User user = (User) session.getAttribute("user");
        final String role = (String) session.getAttribute("role");
        final Map<String, Object> answers = new HashMap<>();
        answers.put("role", role);
        answers.put("user", user.getName());
        final String filter = json.get("filter");
        List<Ads> adsList = new ArrayList<>();
        final List<Ads> allAds = getAdmin().findAllAds();
        if (Objects.equals(filter, "1")) {
            adsList = allAds;
            answers.put("list", adsList);
        } else if (Objects.equals(filter, "2")) {
            for (final Ads ads : allAds) {
                for (final Foto foto : ads.getFoto()) {
                    if (foto.getValues().contains("default")) {
                        adsList.add(ads);
                    }
                }
            }
            answers.put("list", adsList);
        }
        setOut(resp, answers);
    }
}
