package ua.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Engine.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/31/2020
 */
@Entity
@Table(name = "engine")
public class Engine {
    /**
     * field a id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_engine")
    private int id;

    /**
     * field a volume.
     */
    @Column(name = "volume", nullable = false)
    private String volume;

    /**
     * Constructor.
     */
    public Engine() {
    }

    /**
     * Constructor.
     *
     * @param aVolume a volume
     */
    public Engine(final String aVolume) {
        this.volume = aVolume;
    }

    /**
     * Constructor.
     *
     * @param aId     a id
     * @param aVolume a volume
     */
    public Engine(final int aId, final String aVolume) {
        this.id = aId;
        this.volume = aVolume;
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
    @SuppressWarnings("unused")
    public final void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return a volume
     */
    public final String getVolume() {
        return this.volume;
    }

    /**
     * Method to set.
     *
     * @param aVolume a volume
     **/
    public final void setVolume(final String aVolume) {
        this.volume = aVolume;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engine)) {
            return false;
        }
        final Engine engine = (Engine) o;
        return getId() == engine.getId()
                && getVolume().equals(engine.getVolume());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getVolume());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Engine.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("volume='" + this.volume + "'")
                .toString();
    }
}
