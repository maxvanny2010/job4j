package patterns.structure.proxy.proxyprotected.access;

import patterns.structure.proxy.proxyprotected.users.User;
import patterns.structure.proxy.proxyprotected.users.UserGuest;

import java.util.Map;

/**
 * AccessStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
@SuppressWarnings("unused")
class AccessStore {
    /**
     * field map.
     */
    private final Map<String, AccessAbs> map = Map.of(
            "user", new AccessReal(new User("user")),
            "admin", new AccessReal(new User("admin"))
    );

    /**
     * Method to get users by category.
     *
     * @param category the category
     * @return the user
     */
    public final AccessAbs select(final String category) {
        return this.map.getOrDefault(category,
                new AccessDefine(new UserGuest("guest")));
    }
}
