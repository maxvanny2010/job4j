package web.model;

import java.time.LocalDateTime;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */

public class User {

    /**
     * field id.
     */
    private final int id;
    /**
     * field create date.
     */
    private final String createTime;
    /**
     * field name.
     */
    private String name;
    /**
     * field login.
     */
    private String login;
    /**
     * field email.
     */
    private String email;

    /**
     * Constructor.
     *
     * @param aName  a name
     * @param aLogin a login
     * @param aEmail a email
     */
    public User(final String aName, final String aLogin, final String aEmail) {
        this.id = Atomic.ATOMIC_INTEGER.getAndIncrement();
        this.name = aName;
        this.login = aLogin;
        this.email = aEmail;
        this.createTime = getTime();
    }

    /**
     * Method to get.
     *
     * @return a date and a time
     */
    private String getTime() {
        final String time = LocalDateTime.now().toString()
                .split("T")[1]
                .split("\\.")[0];
        return String.format("%s", time);
    }

    /**
     * Getter.
     *
     * @return id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Method to get.
     *
     * @return the date of created the user.
     */
    public final String getCreateTime() {
        return this.createTime;
    }

    /**
     * Method to get.
     *
     * @return a name of user
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Method to set.
     *
     * @param aName a name of user
     **/
    public final void setName(final String aName) {
        this.name = aName;
    }

    /**
     * Method to get.
     *
     * @return a login of user
     */
    public final synchronized String getLogin() {
        return this.login;
    }

    /**
     * Method to set.
     *
     * @param aLogin a login of user
     **/
    public final void setLogin(final String aLogin) {
        this.login = aLogin;
    }

    /**
     * Method to get.
     *
     * @return a email of user
     */
    public final synchronized String getEmail() {
        return this.email;
    }

    /**
     * Method to set.
     *
     * @param aEmail a email of user
     **/
    public final void setEmail(final String aEmail) {
        this.email = aEmail;
    }

    @Override
    public final String toString() {
        return String.format("id=%d createTime=%s name=%s login=%s email=%s",
                this.id, this.createTime, this.name, this.login, this.email);
    }
}
