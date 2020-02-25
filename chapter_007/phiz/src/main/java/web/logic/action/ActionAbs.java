package web.logic.action;

import web.model.User;
import web.persistent.DbStore;
import web.persistent.Store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * ActionAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public abstract class ActionAbs implements Action {
    /**
     * field a keeper for id users from bd.
     */
    private static final Set<Integer> KEEPER = new HashSet<>();
    /**
     * field a map.
     */
    private static Store<User> store;

    /**
     * Constructor.
     */
    ActionAbs() {
        store = DbStore.getInstance();
    }

    /**
     * Method to get.
     *
     * @return a store of memory
     */
    public final Store<User> getStore() {
        return store;
    }

    /**
     * Method to get.
     *
     * @return a keeper for id users from bd
     */
    public final Set<Integer> getKeeper() {
        return KEEPER;
    }

    /**
     * Method to prepare and get.
     *
     * @param resp    a response
     * @param session a session
     * @param id      a id
     * @throws IOException IOException
     */
    protected final void userToSetInSession(final String id,
                                            final HttpSession session,
                                            final HttpServletResponse resp)
            throws IOException {
        if (id != null) {
            final int parseInt = Integer.parseInt(id);
            final Optional<User> user = this.getStore().findById(parseInt);
            user.ifPresent(value -> session.setAttribute("user", value));
        } else {
            resp.sendRedirect("/404");
        }
    }

    /**
     * Method to get user and to set it to a request.
     *
     * @param id  a id
     * @param req a request
     */
    protected final void setUserInRequest(final String id,
                                          final HttpServletRequest req) {
        final int parseInt = Integer.parseInt(id);
        final Optional<User> users = this.getStore().findById(parseInt);
        final User user = users.orElseThrow();
        final boolean is = this.getKeeper().contains(user.getId());
        if (is) {
            req.setAttribute("user", user);
        } else {
            throw new RuntimeException();
        }
    }
}
