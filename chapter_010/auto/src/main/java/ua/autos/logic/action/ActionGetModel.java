package ua.autos.logic.action;

import ua.autos.model.auto.Brands;
import ua.autos.model.auto.Models;
import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionGeModel.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/13/2020
 */
public class ActionGetModel extends ActionAbs {

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        if (Objects.equals(session, null)) {
            session = req.getSession();
            session.setAttribute("role", "unknown");
            session.setAttribute("user", new User("unknown"));
        }
        final Map<String, Object> answers = new HashMap<>();
        final String filter = json.get("filter");
        final Brands brands = getAuto().getModels(filter);
        final Set<Models> models = brands.getModels();
        answers.put("set", models);
        setOut(resp, answers);
    }
}
