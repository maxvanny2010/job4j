package ua.nino.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ua.nino.model.ads.Ads;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public class User {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a name.
     */
    private String name;
    /**
     * field a login.
     */
    @JsonIgnore
    private String login;
    /**
     * field a password.
     */
    @JsonIgnore
    private String password;

    /**
     * field a phones.
     */
    private String phone;

    /**
     * field email.
     */
    private String email;
    /**
     * field ads.
     */
    private Set<Ads> ads = new HashSet<>();


    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param aName     a name
     * @param aEmail    a email
     * @param aLogin    a login
     * @param aPhone    a phone
     * @param aPassword a password
     */
    public User(final String aName, final String aEmail,
                final String aLogin, final String aPassword,
                final String aPhone) {
        this.name = aName;
        this.email = aEmail;
        this.login = aLogin;
        this.password = aPassword;
        this.phone = aPhone;
    }

    /**
     * Constructor.
     *
     * @param aName a name
     */
    public User(final String aName) {
        this.name = aName;
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
     * @return a brand
     */
    public final String getName() {
        return this.name;
    }


    /**
     * Method to set.
     *
     * @param aName a name
     **/
    public final void setName(final String aName) {
        this.name = aName;
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
     * @return email
     */
    public final String getEmail() {
        return this.email;
    }

    /**
     * Method to set.
     *
     * @param aEmail emails
     **/
    public final void setEmail(final String aEmail) {
        this.email = aEmail;
    }

    /**
     * Method to get.
     *
     * @return phone
     */
    public final String getPhone() {
        return this.phone;
    }

    /**
     * Method to set.
     *
     * @param aPhone phones
     **/
    public final void setPhone(final String aPhone) {
        this.phone = aPhone;
    }

    /**
     * Method to get.
     *
     * @return ads
     */
    public final Set<Ads> getAds() {
        return this.ads;
    }

    /**
     * Method to set.
     *
     * @param aAds ads
     **/
    public final void setAds(final Set<Ads> aAds) {
        this.ads = aAds;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        final User user = (User) o;
        return getId() == user.getId()
                && getName().equals(user.getName())
                && getPassword().equals(user.getPassword())
                && getLogin().equals(user.getLogin())
                && getEmail().equals(user.getEmail())
                && getPhone().equals(user.getPhone());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getName(), getPassword(), getLogin());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                User.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("name='" + this.name + "'")
                .add("login='" + this.login + "'")
                .add("password='" + this.password + "'")
                .add("email=" + this.email)
                .add("phone=" + this.phone)
                .add("ads=" + this.ads)
                .toString();
    }
}
