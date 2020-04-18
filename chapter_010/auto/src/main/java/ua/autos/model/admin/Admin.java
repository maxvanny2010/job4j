package ua.autos.model.admin;

import ua.autos.model.user.User;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Admin.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/24/2020
 */
public class Admin {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a user.
     */
    private Set<User> users;

    /**
     * Constructor.
     */
    public Admin() {
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
     * Method to set.
     *
     * @param aId a id
     **/
    public final void setId(final Set<User> aId) {
        this.users = aId;
    }

    /**
     * Method to get.
     *
     * @return a set of users
     */
    public final Set<User> getUsers() {
        return this.users;
    }

    /**
     * Method to set.
     *
     * @param aUser a user
     **/
    public final void setUsers(final Set<User> aUser) {
        this.users = aUser;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Admin)) {
            return false;
        }
        final Admin admin = (Admin) o;
        return getId() == admin.getId()
                && Objects.equals(getUsers(), admin.getUsers());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getUsers());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Admin.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("users=" + this.users)
                .toString();
    }
}
