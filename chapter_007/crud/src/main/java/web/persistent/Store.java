package web.persistent;

import web.model.User;

import java.util.List;

/**
 * Store.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */
public interface Store {
    /**
     * Method to add.
     *
     * @param user a user
     */
    void add(User user);

    /**
     * Method to update.
     *
     * @param user a user.
     */
    void update(User user);

    /**
     * Method to delete.
     *
     * @param user a user
     */
    void delete(User user);

    /**
     * Method to find all user from storage.
     *
     * @return users by list
     */
    List<User> findAll();

    /**
     * Method to find the user by id.
     *
     * @param id a id of user
     * @return a user or null
     */
    User findById(int id);

    /**
     * Method to clear a store.
     */
    void clearStore();
}
