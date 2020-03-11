package web.logic.stub;

import web.model.User;
import web.persistent.Store;
import web.persistent.StoreMemory;

import java.util.HashSet;
import java.util.Set;

/**
 * ActionAds.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/27/2020
 */
public final class ActionStub {
    /**
     * field a keeper for id users from bd.
     */
    private static final Set<Integer> KEEPER = new HashSet<>();
    /**
     * field a map.
     */
    private static final Store<User> STORE = StoreMemory.getInstance();

    /**
     * Constructor.
     */
    private ActionStub() {
    }

    /**
     * Method to get.
     *
     * @return a store of memory
     */
    public static Store<User> getStore() {
        return STORE;
    }

    /**
     * Method to get.
     *
     * @return a keeper for id users from bd
     */
    public static Set<Integer> getKeeper() {
        return KEEPER;
    }
}
