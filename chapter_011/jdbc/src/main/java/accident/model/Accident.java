package accident.model;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Accident.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Component
public class Accident {
    /**
     * field a atom.
     */
    public static final AtomicInteger ATOM = new AtomicInteger();
    /**
     * field a id.
     */
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
     *
     * @param aName    a name
     * @param aAddress a address
     * @param aText    a text
     */
    public Accident(final String aName,
                    final String aAddress,
                    final String aText) {
        this.id = ATOM.getAndIncrement();
        this.name = aName;
        this.text = aText;
        this.address = aAddress;
    }

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
     * @return a text
     */
    public final String getText() {
        return this.text;
    }

    /**
     * Method to set.
     *
     * @param aText a text
     **/
    public final void setText(final String aText) {
        this.text = aText;
    }

    /**
     * Method to get.
     *
     * @return a address
     */
    public final String getAddress() {
        return this.address;
    }

    /**
     * Method to set.
     *
     * @param aAddress a address
     **/
    public final void setAddress(final String aAddress) {
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
