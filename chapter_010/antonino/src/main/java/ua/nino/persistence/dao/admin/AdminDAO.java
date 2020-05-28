package ua.nino.persistence.dao.admin;

import ua.nino.model.ads.Ads;
import ua.nino.model.ads.Status;
import ua.nino.model.user.User;
import ua.nino.persistence.dao.store.IStore;

import java.util.List;

/**
 * AdminDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/24/2020
 */
public interface AdminDAO extends IStore<User> {
    /**
     * Method to delete a table by name.
     *
     * @param name a name
     */
    void dropTable(String name);

    /**
     * Method to find.
     *
     * @param name a name of user
     * @return a user
     */
    User findUserBy(String name);

    /**
     * Method to find a data of user(phone, email).
     *
     * @param <E>    a type of return value
     * @param tClass a name of class for set name table
     * @param value  a value of user
     * @return a phone
     */
    <E> User findUserBy(String value, Class<E> tClass);

    /**
     * Method to find.
     *
     * @param user   a user
     * @param status a ads
     * @return a ads
     */
    List<Ads> findAdsBy(Status status, User user);

    /**
     * Method to find.
     *
     * @param user a user
     * @return a ads
     */
    List<Ads> findAdsBy(User user);

    /**
     * Method to find.
     *
     * @return a ads
     */
    List<User> findAllUsers();

    /**
     * Method to find.
     *
     * @return a ads
     */
    List<Ads> findAllAds();

    /**
     * Method to find a login of user.
     *
     * @param login a login
     * @return a login
     */
    User findByLogin(String login);

    /**
     * Method to find a login of user.
     *
     * @param password a password
     * @return a login
     */
    User findBy(String password);

    /**
     * Method to get.
     *
     * @param login    a user login
     * @param password a user password
     * @return result
     */
    User findRoles(String login, String password);
}
