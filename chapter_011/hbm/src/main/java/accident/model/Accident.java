package accident.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "hbm")
public class Accident {
    /**
     * field a id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hbm")
    private int id;
    /**
     * field a name.
     */
    private String name;
    /**
     * field a text.
     */
    private String text;
    /**
     * field a address.
     */
    private String address;

    /**
     * Constructor.
     */
    public Accident() {
    }

    /**
     * Method to get.
     *
     * @return a id
     */
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
     * @return a name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to set.
     *
     * @param aName a name
     **/
    public void setName(final String aName) {
        this.name = aName;
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
                && Objects.equals(getName(), accident.getName())
                && Objects.equals(getText(), accident.getText())
                && Objects.equals(getAddress(), accident.getAddress());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getName(), getText(), getAddress());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Accident.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("name='" + this.name + "'")
                .add("text='" + this.text + "'")
                .add("address='" + this.address + "'")
                .toString();
    }
}
