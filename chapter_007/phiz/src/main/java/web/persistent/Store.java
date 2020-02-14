package web.persistent;

import java.util.List;

/**
 * Store.
 *
 * @param <T> type
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */
public interface Store<T> {
    /**
     * Method to add.
     *
     * @param user a user
     */
    void add(T user);

    /**
     * Method to update.
     *
     * @param user a user.
     */
    void update(T user);

    /**
     * Method to delete.
     *
     * @param user a user
     */
    void delete(T user);

    /**
     * Method to find all user from storage.
     *
     * @return users by list
     */
    List<T> findAll();

    /**
     * Method to find the user by id.
     *
     * @param id a id of user
     * @return a user or null
     */
    T findById(int id);

    /**
     * Method to clear a store.
     */
    void clearStore();
}
