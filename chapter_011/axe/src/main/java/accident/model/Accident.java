package accident.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.StringJoiner;

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
     * field a id.
     */
    private int id;
    /**
     * field a name.
     */
    private String name;
    /**
     * field a address.
     */
    private String address;

    /**
     * field a address.
     */
    private String number;
    /**
     * field a text.
     */
    private String desc;

    /**
     * field a foto.
     */
    private byte[] foto;

    /**
     * Constructor.
     *
     * @param aName    a name
     * @param aNumber  a number
     * @param aAddress a address
     * @param aText    a text
     */
    public Accident(final String aName,
                    final String aNumber,
                    final String aAddress,
                    final String aText) {
        this.name = aName;
        this.number = aNumber;
        this.desc = aText;
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
     * @return a image by a byte array
     */
    public final String getImage() {
        return Base64.getEncoder().encodeToString(this.foto);
    }

    /**
     * Method to get.
     *
     * @return a foto
     */
    public final byte[] getFoto() {
        return this.foto;
    }

    /**
     * Method to set.
     *
     * @param aFoto a foto
     **/
    public final void setFoto(final byte[] aFoto) {
        this.foto = aFoto;
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
    public final String getDesc() {
        return this.desc;
    }

    /**
     * Method to set.
     *
     * @param aText a text
     **/
    @SuppressWarnings("unused")
    public final void setDesc(final String aText) {
        this.desc = aText;
    }

    /**
     * Method to get.
     *
     * @return a number
     */
    public final String getNumber() {
        return this.number;
    }

    /**
     * Method to set.
     *
     * @param aNumber a number
     **/
    @SuppressWarnings("unused")
    public final void setNumber(final String aNumber) {
        this.number = aNumber;
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
                && Objects.equals(getNumber(), accident.getNumber())
                && Objects.equals(getAddress(), accident.getAddress())
                && Objects.equals(getDesc(), accident.getDesc())
                && Arrays.equals(getFoto(), accident.getFoto());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getName(), getNumber(),
                getDesc(), getAddress(), getFoto());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Accident.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("name='" + this.name + "'")
                .add("number='" + this.number + "'")
                .add("address='" + this.address + "'")
                .add("desc='" + this.desc + "'")
                .toString();
    }
}
