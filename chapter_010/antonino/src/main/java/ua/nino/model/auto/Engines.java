package ua.nino.model.auto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Volumes.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
@Entity
@Table(name = "engines")
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
     *
     * @param aEngine a volume
     */
    public Engines(final String aEngine) {
        this.values = aEngine;
    }

    /**
     * Constructor.
     */
    public Engines() {
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_engine")
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
    @Column(name = "values")
    public String getValues() {
        return this.values;
    }

    /**
     * Method to set.
     *
     * @param aName a name
     **/
    public void setValues(final String aName) {
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
    public final String toString() {
        return new StringJoiner(", ",
                Engines.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .toString();
    }
}
