package ua.nino.model.role;

import ua.nino.model.user.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Role.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/22/2020
 */
public enum Role {

    /**
     * field a admin.
     */
    ADMIN() {
        @Override
        public void apply(final User user, final HttpSession session) {
            session.setAttribute("role", user.getName());
            session.setAttribute("user", new User("admin"));
        }
    },

    /**
     * field a user.
     */
    USER() {
        @Override
        public void apply(final User user, final HttpSession session) {
            session.setAttribute("role", "user");
            session.setAttribute("user", user);
        }
    },

    /**
     * field a unknown.
     */
    UNKNOWN() {
        @Override
        public void apply(final User user, final HttpSession session) {
            session.setAttribute("role", user.getName());
            session.setAttribute("user", new User("unknown"));
        }
    };

    /**
     * field a map of action by role.
     */
    private static final HashMap<String, Role> ROLE_MAP = new HashMap<>() {{
        put("admin", Role.ADMIN);
        put("user", Role.USER);
        put("unknown", Role.UNKNOWN);
    }};

    /**
     * Method to get.
     *
     * @param role a role
     * @return a action by role
     */
    public static Role factoryRoles(final String role) {
        return ROLE_MAP.getOrDefault(role, Role.USER);
    }

    /**
     * Method a action by role.
     *
     * @param session a session
     * @param user    a user
     */
    public void apply(final User user, final HttpSession session) {
    }
}
