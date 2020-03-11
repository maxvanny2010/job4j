package web.model;

import web.logic.action.ActionAbs;
import web.logic.action.utils.actionutil.PropUtil;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static web.logic.action.ActionLogin.FILE;

/**
 * Role.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/20/2020
 */
public enum Role {
    /**
     * field a admin.
     */
    ADMIN() {
        @Override
        public void apply(final String login, final String password,
                          final HttpSession session) {
            final boolean admin = PropUtil.findAdminBy(login, password, FILE);
            if (admin) {
                session.setAttribute("role", "admin");
            } else {
                System.out.println("Profile is absent");
                session.setAttribute("infoGate", "Профиль не найден");
                session.setAttribute("role", "unknown");
            }
        }
    },

    /**
     * field a user.
     */
    USER() {
        @Override
        public void apply(final String login, final String password,
                          final HttpSession session) {
            final Optional<User> users = ActionAbs.getStore()
                    .findUserBy(login, password);
            if (users.isPresent()) {
                final User user = users.get();
                session.setAttribute("user", user);
                session.setAttribute("role", "user");
            } else {
                System.out.println("Profile is absent");
                session.setAttribute("infoGate", "Профиль не найден");
                session.setAttribute("role", "unknown");
            }
        }
    },
    /**
     * field a user.
     */
    UNKNOWN() {
        @Override
        public void apply(final String login, final String password,
                          final HttpSession session) {
            session.setAttribute("role", "unknown");
        }
    };
    /**
     * field a map of action by role.
     */
    private static final Map<String, Role> ROLE_MAP = new HashMap<>() {{
        put("admin", Role.ADMIN);
        put("user", Role.USER);
        put("unknown", Role.UNKNOWN);
    }};

    /**
     * Method to get.
     *
     * @param aRole a role
     * @return a action by role
     */
    public static Role factoryRoles(final String aRole) {
        return ROLE_MAP.getOrDefault(aRole, Role.UNKNOWN);
    }

    /**
     * Method a action by role.
     *
     * @param login    a login
     * @param password a password
     * @param session  a session
     */
    public void apply(final String login, final String password,
                      final HttpSession session) {
    }
}
