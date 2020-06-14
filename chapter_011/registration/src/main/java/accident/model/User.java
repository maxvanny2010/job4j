package accident.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/11/2020
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * field a id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * field a username.
     */
    private String username;
    /**
     * field a password.
     */
    private String password;
    /**
     * field a active state.
     */
    private boolean enabled;
    /**
     * field a role of user.
     */
    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;
    /**
     * field a accident.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",
            cascade = CascadeType.ALL)
    private Set<Accident> dtp = new HashSet<>();

    /**
     * Method to get.
     *
     * @return username
     */
    @SuppressWarnings("unused")
    public String getUsername() {
        return this.username;
    }

    /**
     * Method to set.
     *
     * @param aUsername username
     **/
    @SuppressWarnings("unused")
    public void setUsername(final String aUsername) {
        this.username = aUsername;
    }

    /**
     * Method to get.
     *
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Method to set.
     *
     * @param aPassword a password
     **/
    public void setPassword(final String aPassword) {
        this.password = aPassword;
    }

    /**
     * Method to set.
     *
     * @param aEnable active state
     **/
    public void setEnable(final boolean aEnable) {
        this.enabled = aEnable;
    }

    /**
     * Method to get.
     *
     * @return accidents
     */
    public Set<Accident> getDtp() {
        return this.dtp;
    }

    /**
     * Method to set.
     *
     * @param aDtp accidents
     **/
    @SuppressWarnings("unused")
    public void setDtp(final Set<Accident> aDtp) {
        this.dtp = aDtp;
    }

    /**
     * Method to get.
     *
     * @return state
     */
    @SuppressWarnings("unused")
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Method to get.
     *
     * @return roles by user
     */
    @SuppressWarnings("unused")
    public Authority getAuthority() {
        return this.authority;
    }

    /**
     * Method to set.
     *
     * @param aAuthority a roles
     **/
    @SuppressWarnings("unused")
    public void setAuthority(final Authority aAuthority) {
        this.authority = aAuthority;
    }

    /**
     * Method to get.
     *
     * @return id
     */
    @SuppressWarnings("unused")
    public Long getId() {
        return this.id;
    }
}
