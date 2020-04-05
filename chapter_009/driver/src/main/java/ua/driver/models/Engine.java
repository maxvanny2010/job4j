package ua.driver.models;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Engine.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/31/2020
 */
public class Engine {
    /**
     * field a id.
     */
    private int id;

    /**
     * field a volume.
     */
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
