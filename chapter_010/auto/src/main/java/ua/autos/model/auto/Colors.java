package ua.autos.model.auto;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Colors.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public class Colors {
    /**
     * field a id.
     */
    private int id;

    /**
     * field a value of brand.
     */
    private String values;

    /**
     * Constructor.
     */
    public Colors() {
    }

    /**
     * Constructor.
     *
     * @param aColors a color
     */
    public Colors(final String aColors) {
        this.values = aColors;
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

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Colors)) {
            return false;
        }
        final Colors colors = (Colors) o;
        return getId() == colors.getId()
                && getValues().equals(colors.getValues());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getValues());
    }

    @Override
    public final java.lang.String toString() {
        return new StringJoiner(", ",
                Colors.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .toString();
    }
}
