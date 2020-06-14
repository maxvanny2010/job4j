package accident.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Authority.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/14/2020
 */
@Entity
@Table(name = "authorities")
public class Authority {
    /**
     * field a id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * field a name of role.
     */
    private String authority;

    /**
     * Constructor.
     */
    public Authority() {
    }

    /**
     * Method to get.
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId a Id
     **/
    @SuppressWarnings("unused")
    public void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return role
     */
    public String getAuthority() {
        return this.authority;
    }

    /**
     * Method to set.
     *
     * @param aAuthority a role
     **/
    @SuppressWarnings("unused")
    public void setAuthority(final String aAuthority) {
        this.authority = aAuthority;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Authority)) {
            return false;
        }
        final Authority authority1 = (Authority) o;
        return getId() == authority1.getId()
                && getAuthority().equals(authority1.getAuthority());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getAuthority());
    }
}
