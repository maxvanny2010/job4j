package ua.nino.logic.action;

import ua.nino.model.ads.Ads;
import ua.nino.model.role.Role;
import ua.nino.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionLogin.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/20/2020
 */
public class ActionLogin extends ActionAbs {

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        final HttpSession session = req.getSession(false);
        final String login = json.get("login");
        final String password = json.get("password");
        final User user = getAdmin().findRoles(login, password);
        Role.factoryRoles(user.getName()).apply(user, session);
        final String role = (String) session.getAttribute("role");
        final Map<String, Object> answers = new HashMap<>();
        answers.put("role", role);
        answers.put("user", "unknown");
        if (Objects.equals(role, "user")) {
            idxUser().add(user.getId());
            user.getAds().stream().mapToInt(Ads::getId).forEach(idxAds()::add);
            answers.put("user", user.getName());
        } else if (Objects.equals(role, "admin")) {
            getAdmin().findAllUsers().stream()
                    .mapToInt(User::getId).forEach(idxAdmin()::add);
            answers.put("user", "admin");
        }
        setOut(resp, answers);
    }
}

