package ua.nino.model.ads;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Foto.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public class Foto {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a foto.
     */
    private String values;
    /**
     * field a foto name.
     */
    private String name;
    /**
     * field a ads.
     */
    @JsonIgnore
    private Ads ads;

    /**
     * Constructor.
     */
    public Foto() {
    }

    /**
     * Constructor.
     *
     * @param aFoto a foto
     */
    public Foto(final String aFoto) {
        this.values = aFoto;
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
     */
    public final void setName(final String aName) {
        this.name = aName;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId());
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
     * @return foto
     */
    public final String getValues() {
        return this.values;
    }

    /**
     * Method to set.
     *
     * @param aFoto foto
     **/
    public final void setValues(final String aFoto) {
        this.values = aFoto;
    }

    /**
     * Method to get.
     *
     * @return a ads
     */
    public final Ads getAds() {
        return this.ads;
    }

    /**
     * Method to set.
     *
     * @param aAds a ads
     **/
    public final void setAds(final Ads aAds) {
        this.ads = aAds;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Foto)) {
            return false;
        }
        final Foto foto1 = (Foto) o;
        return getId() == foto1.getId()
                && Objects.equals(getValues(), foto1.getValues())
                && Objects.equals(getName(), foto1.getName());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Foto.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("name=" + this.name)
                .add("ads=" + this.ads)
                .toString();
    }
}
