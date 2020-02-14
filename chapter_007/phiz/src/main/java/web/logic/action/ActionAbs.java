package web.logic.action;

import web.model.User;
import web.persistent.DbStore;
import web.persistent.Store;

import javax.servlet.http.HttpServletRequest;

/**
 * ActionAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public abstract class ActionAbs implements Action {
    /**
     * field a map.
     */
    private final Store<User> store;

    /**
     * Constructor.
     */
    ActionAbs() {
        this.store = DbStore.getInstance();
    }

    /**
     * Method to get.
     *
     * @return a store of memory
     */
    public final Store<User> getStore() {
        return this.store;
    }

    /**
     * Method to prepare and get.
     *
     * @param req a request
     * @return a user by id
     *
     * @throws IllegalArgumentException IllegalArgumentException
     */
    protected final User getUserIdByRequest(final HttpServletRequest req) {
        final String idUser = req.getParameter("id");
        final int id = Integer.parseInt(idUser);
        final User user = this.getStore().findById(id);
        if (user == null) {
            throw new IllegalArgumentException("user hasn't in store");
        }
        return user;
    }
}
