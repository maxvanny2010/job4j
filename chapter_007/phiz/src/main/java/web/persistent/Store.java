package web.persistent;

import java.util.List;
import java.util.Optional;

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
    Optional<T> findById(int id);

    /**
     * Method to get.
     *
     * @param login    a login user
     * @param password a password user
     * @return credential
     */
    Optional<T> findUserBy(String login, String password);

    /**
     * Method to get.
     *
     * @param login    a login user
     * @param password a password user
     * @return id
     */
    int findIdBy(String login, String password);

    /**
     * Method to check.
     *
     * @param login a login user
     * @return a result
     */
    boolean isLogin(String login);

    /**
     * Method to clear a store.
     */
    void clearStore();
}
