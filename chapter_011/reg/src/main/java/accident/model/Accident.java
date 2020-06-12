package accident.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Accident.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Entity
@Table(name = "accident")
public class Accident {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a name.
     */
    private String number;
    /**
     * field a text.
     */
    private String text;
    /**
     * field a address.
     */
    private String address;

    private User user;

    /**
     * Constructor.
     */
    public Accident() {
    }

    /**
     * Method to get.
     *
     * @return user
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "user_id_fk"),
            nullable = false)
    public User getUser() {
        return this.user;
    }

    /**
     * Method to set.
     *
     * @param aUser user
     **/
    public void setUser(final User aUser) {
        this.user = aUser;
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accident")
    public int getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId a id
     **/
    public void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return a number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Method to set.
     *
     * @param aName a number
     **/
    public void setNumber(final String aName) {
        this.number = aName;
    }

    /**
     * Method to get.
     *
     * @return a text
     */
    public String getText() {
        return this.text;
    }

    /**
     * Method to set.
     *
     * @param aText a text
     **/
    public void setText(final String aText) {
        this.text = aText;
    }

    /**
     * Method to get.
     *
     * @return a address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Method to set.
     *
     * @param aAddress a address
     **/
    public void setAddress(final String aAddress) {
        this.address = aAddress;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Accident)) {
            return false;
        }
        final Accident accident = (Accident) o;
        return getId() == accident.getId()
                && Objects.equals(getNumber(), accident.getNumber())
                && Objects.equals(getText(), accident.getText())
                && Objects.equals(getAddress(), accident.getAddress())
                && Objects.equals(getUser(), accident.getUser()
        );
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getNumber(),
                getText(), getAddress(), getUser());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Accident.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("number='" + this.number + "'")
                .add("text='" + this.text + "'")
                .add("address='" + this.address + "'")
                .add("user='" + this.user + "'")
                .toString();
    }
}
