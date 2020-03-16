package ua.emailtime.models;

import java.sql.Timestamp;
import java.util.StringJoiner;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/13/2020
 */
public class User {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a login.
     */
    private String login;
    /**
     * field a password.
     */
    private String password;
    /**
     * field a time.
     */
    private Timestamp created;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Method to get.
     *
     * @return a created
     */
    public final Timestamp getCreated() {
        return this.created;
    }

    /**
     * Method to set.
     *
     * @param aCreated a created
     **/
    public final void setCreated(final Timestamp aCreated) {
        this.created = aCreated;
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId a id
     **/
    public final void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return a login
     */
    public final String getLogin() {
        return this.login;
    }

    /**
     * Method to set.
     *
     * @param aLogin a login
     **/
    public final void setLogin(final String aLogin) {
        this.login = aLogin;
    }

    /**
     * Method to get.
     *
     * @return a password
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * Method to set.
     *
     * @param aPassword a password
     **/
    public final void setPassword(final String aPassword) {
        this.password = aPassword;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("login='" + login + "'")
                .add("password='" + password + "'")
                .add("created=" + created)
                .toString();
    }
}
