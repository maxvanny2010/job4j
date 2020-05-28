package ua.nino.logic.action;

import ua.nino.model.auto.Brands;
import ua.nino.model.auto.Models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

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
        final Map<String, Object> answers = new HashMap<>();
        final String filter = json.get("filter");
        final Brands brands = getAuto().getModels(filter);
        final Set<Models> models = brands.getModels();
        answers.put("set", models);
        setOut(resp, answers);
    }
}
