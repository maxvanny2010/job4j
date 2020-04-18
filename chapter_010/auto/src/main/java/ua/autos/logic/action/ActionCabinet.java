package ua.autos.logic.action;

import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionCabinet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/24/2020
 */
public class ActionCabinet extends ActionAbs {
    /**
     * field a map.
     */
    private final Map<String, Help> helper = new HashMap<>() {{
        put("user", new HelperUser());
        put("admin", new HelperAdmin());
    }};

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        final HttpSession session = req.getSession(false);
        final String roils = json.get("role");
        final String names = json.get("name");
        final String role = (String) session.getAttribute("role");
        final User user = (User) session.getAttribute("user");
        final boolean isRoles = Objects.equals(roils, role);
        final boolean isNames = Objects.equals(names, user.getName());
        Map<String, Object> outs = new HashMap<>();
        if (isRoles && isNames) {
            outs = this.helper.get(role).getAnswer(session);
        } else {
            outs.put("size", "0");
        }
        setOut(resp, outs);
    }

    /**
     * Interface.
     */
    private interface Help {
        /**
         * Method to get.
         *
         * @param session a session
         * @return a answer
         */
        Map<String, Object> getAnswer(HttpSession session);
    }

    /**
     * inner class HelperUser.
     */
    private static class HelperUser implements Help {
        @Override
        public final Map<String, Object> getAnswer(final HttpSession session) {
            final User user = (User) session.getAttribute("user");
            final Map<String, Object> map = new HashMap<>();
            map.put("role", "user");
            map.put("list", user);
            return map;
        }
    }

    /**
     * inner class HelperUser.
     */
    private static class HelperAdmin implements Help {
        @Override
        public Map<String, Object> getAnswer(final HttpSession session) {
            final Map<String, Object> map = new HashMap<>();
            map.put("role", "admin");
            map.put("list", getAdmin().findAllUsers());
            return map;
        }
    }
}
