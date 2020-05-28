package ua.nino.logic.action;


import ua.nino.persistence.dao.store.AdminStore;
import ua.nino.persistence.dao.store.AdsStore;
import ua.nino.persistence.dao.store.AutoStore;
import ua.nino.persistence.dao.store.UserStore;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * ActionAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public abstract class ActionAbs implements Action {
    /**
     * field a keeper id for user.
     */
    private static final Set<Integer> KEEPER_USER = new HashSet<>();
    /**
     * field a keeper for id users for admin.
     */
    private static final Set<Integer> KEEPER_ADMIN = new HashSet<>();
    /**
     * field a keeper id  ads user.
     */
    private static final Set<Integer> KEEPER_ADS = new HashSet<>();
    /**
     * field a ads store.
     */
    private static final AdsStore ADS = new AdsStore();
    /**
     * field a auto store.
     */
    private static final AutoStore AUTO = new AutoStore();
    /**
     * field a user store.
     */
    private static final UserStore USER = new UserStore();
    /**
     * field a admin store.
     */
    private static final AdminStore ADMIN = new AdminStore();

    /**
     * Constructor.
     */
    ActionAbs() {
    }

    /**
     * Method to get.
     *
     * @return a keeper id's users
     */
    public static Set<Integer> idxUser() {
        return KEEPER_USER;
    }

    /**
     * Method to get.
     *
     * @return a keeper for id's users for admin
     */
    public static Set<Integer> idxAdmin() {
        return KEEPER_ADMIN;
    }

    /**
     * Method to get.
     *
     * @return a keeper id's ads by user
     */
    public static Set<Integer> idxAds() {
        return KEEPER_ADS;
    }

    /**
     * Method to get.
     *
     * @return the ads store
     */
    public static AdsStore getAds() {
        return ADS;
    }

    /**
     * Method to get.
     *
     * @return the auto store
     */
    public static AutoStore getAuto() {
        return AUTO;
    }

    /**
     * Method to get.
     *
     * @return the user store
     */
    public static UserStore getUser() {
        return USER;
    }

    /**
     * Method to get.
     *
     * @return the admin store
     */
    public static AdminStore getAdmin() {
        return ADMIN;
    }

    /**
     * Method to prepare and get.
     *
     * @param id   a id
     * @param func a function interface
     * @param set  a set
     * @return result
     */
    protected final boolean isId(final String id,
                                 final BiFunction<String,
                                         Set<Integer>, Boolean> func,
                                 final Set<Integer> set) {
        return this.isInt(id) && func.apply(id, set);
    }

    /**
     * Method to check is int.
     *
     * @param id a id
     * @return a result
     */
    protected final boolean isInt(final String id) {
        return id.matches("[-+]?\\d+");
    }

    /**
     * Method to check id for contain idx by user.
     *
     * @param id  a id
     * @param set a collection
     * @return a result
     */
    protected final boolean isIdx(final String id,
                                  final Set<Integer> set) {
        return set.contains(Integer.parseInt(id));
    }
}
