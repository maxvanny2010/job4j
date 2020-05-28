package ua.nino.logic.action;

import ua.nino.model.ads.Ads;
import ua.nino.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionCabinetAds.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/25/2020
 */
public class ActionCabinetAds extends ActionAbs {

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        final String id = json.get("id");
        final HashMap<Integer, Ads> outs = this.getAnswer(id);
        setOut(resp, outs);
    }

    /**
     * Method to get.
     *
     * @param id a id
     * @return the ads by user
     */
    public final HashMap<Integer, Ads> getAnswer(final String id) {
        final HashMap<Integer, Ads> map = new HashMap<>();
        if (this.isId(id, this::isIdx, idxAdmin())) {
            final int idx = Integer.parseInt(id);
            final User user = getAdmin().getById(idx);
            user.getAds().forEach(v -> map.put(v.getId(), v));
        }
        return map;
    }
}
