package web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/1/2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    /**
     * field a email.
     */
    private String name;
    /**
     * field a login.
     */
    private String login;
    /**
     * field a email.
     */
    private String email;
    /**
     * field a password.
     */
    private String password;
    /**
     * field a image.
     */
    private String img;
    /**
     * field a image.
     */
    @JsonIgnore
    private byte[] image;
    /**
     * field a gender.
     */
    @JsonIgnore
    private String gender;
    /**
     * field a email.
     */
    @JsonIgnore
    private String country;
    /**
     * field a email.
     */
    @JsonIgnore
    private String city;

    /**
     * Constructor.
     */
    private User() {
    }

    /**
     * Constructor.
     *
     * @param aName     a name
     * @param aLogin    a login
     * @param aEmail    a email
     * @param aPassword a password
     * @param aImg      a image by base64
     */
    @JsonCreator
    public User(@JsonProperty("name") final String aName,
                @JsonProperty("login") final String aLogin,
                @JsonProperty("email") final String aEmail,
                @JsonProperty("password") final String aPassword,
                @JsonProperty("img") final String aImg) {
        this();
        this.name = aName;
        this.login = aLogin;
        this.email = aEmail;
        this.password = aPassword;
        this.img = aImg;
        this.gender = null;
        this.country = null;
        this.city = null;
        this.image = null;
    }

    /**
     * Constructor.
     *
     * @param aName     a name
     * @param aEmail    a email
     * @param aCountry  a country
     * @param aCity     a city
     * @param aPassword a password
     * @param aGender   a state
     */
    @SuppressWarnings("unused")
    public User(final String aName, final String aEmail,
                final String aCountry, final String aCity,
                final String aGender, final String aPassword) {
        this();
        this.name = aName;
        this.email = aEmail;
        this.country = aCountry;
        this.city = aCity;
        this.gender = aGender;
        this.password = aPassword;
        this.login = null;
        this.image = null;
        this.img = null;
    }

    /**
     * Constructor.
     *
     * @param aName     a name
     * @param aLogin    a login
     * @param aEmail    a email
     * @param aPassword a password
     * @param aImage    a image
     */
    @SuppressWarnings("unused")
    public User(final String aName, final String aLogin,
                final String aEmail, final String aPassword,
                final byte[] aImage) {
        this();
        this.name = aName;
        this.login = aLogin;
        this.email = aEmail;
        this.password = aPassword;
        this.image = aImage;
        this.gender = null;
        this.country = null;
        this.city = null;
        this.img = null;
    }

    /**
     * Method to get.
     *
     * @return a name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Method to set.
     *
     * @param aName a name
     **/
    @SuppressWarnings("unused")
    public final void setName(final String aName) {
        this.name = aName;
    }

    /**
     * Method to get.
     *
     * @return a email
     */
    public final String getEmail() {
        return this.email;
    }

    /**
     * Method to set.
     *
     * @param aEmail a email
     **/
    @SuppressWarnings("unused")
    public final void setEmail(final String aEmail) {
        this.email = aEmail;
    }

    /**
     * Method to get.
     *
     * @return a country
     */
    @SuppressWarnings("unused")
    public final String getCountry() {
        return this.country;
    }

    /**
     * Method to get.
     *
     * @return a city
     */
    @SuppressWarnings("unused")
    public final String getCity() {
        return this.city;
    }

    /**
     * Method to get.
     *
     * @return a state
     */
    @SuppressWarnings("unused")
    public final String getGender() {
        return this.gender;
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    public final void setLogin(final String aLogin) {
        this.login = aLogin;
    }

    /**
     * Method to get.
     *
     * @return a image
     */
    @SuppressWarnings("unused")
    public final byte[] getImage() {
        return this.image;
    }

    /**
     * Method to get.
     *
     * @return a image vy base64
     */

    public final String getImg() {
        return this.img;
    }

    /**
     * Method to set.
     *
     * @param aImg a img
     **/
    @SuppressWarnings("unused")
    public final void setImg(final String aImg) {
        this.img = aImg;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"name\":\"" + this.name + "\"")
                .add("\"login\":\"" + this.login + "\"")
                .add("\"email\":\"" + this.email + "\"")
                .add("\"password\":\"" + this.password + "\"")
                .add("\"image\":\"" + this.img + "\"")
                .toString();
    }
}
