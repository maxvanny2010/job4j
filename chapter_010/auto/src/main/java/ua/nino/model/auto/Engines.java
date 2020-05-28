package ua.nino.model.auto;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Volumes.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public class Engines {
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
    public Engines() {
    }

    /**
     * Constructor.
     *
     * @param aEngine a volume
     */
    public Engines(final String aEngine) {
        this.values = aEngine;
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
        if (!(o instanceof Engines)) {
            return false;
        }
        final Engines engine = (Engines) o;
        return getId() == engine.getId()
                && getValues().equals(engine.getValues());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getValues());
    }

    @Override
    public final java.lang.String toString() {
        return new StringJoiner(", ",
                Engines.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .toString();
    }
}
