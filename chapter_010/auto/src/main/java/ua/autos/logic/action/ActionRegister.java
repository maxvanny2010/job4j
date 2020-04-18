package ua.autos.logic.action;

import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionRegister.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionRegister extends ActionAbs {
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        final String name = json.get("name");
        final String email = json.get("email");
        final String login = json.get("login");
        final String password = json.get("password");
        final String phone = json.get("phone");
        final User byLogin = getAdmin().findByLogin(login);
        if (Objects.nonNull(byLogin)) {
            setOut(resp, new User("no"));
            return;
        }
        final User user = new User(name, email, login, password, phone);
        getUser().save(user);
        setOut(resp, user);
    }
}
