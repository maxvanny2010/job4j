package ua.autos.model.user;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Emails.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public class Email {
    /**
     * field a id.
     */
    private int id;

    /**
     * field a value of brand.
     */
    private String values;
    /**
     * field a user.
     */
    private User user;

    /**
     * Constructor.
     */
    public Email() {
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
     * @return a name
     */
    public final String getValues() {
        return this.values;
    }

    /**
     * Method to set.
     *
     * @param aName a name
     **/
    public final void setValues(final String aName) {
        this.values = aName;
    }

    /**
     * Method to get.
     *
     * @return a user
     */
    public final User getUser() {
        return this.user;
    }

    /**
     * Method to set.
     *
     * @param aUser a user
     **/
    public final void setUser(final User aUser) {
        this.user = aUser;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Email)) {
            return false;
        }
        final Email email = (Email) o;
        return getId() == email.getId()
                && getValues().equals(email.getValues());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getValues());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Email.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .add("user='" + this.user + "'")
                .toString();
    }
}
