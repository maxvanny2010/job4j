package ua.nino.model.auto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Brands.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public class Brands {
    /**
     * field a id.
     */
    private int id;

    /**
     * field a name of brand.
     */
    private String values;
    /**
     * field foto.
     */
    private Set<Models> models = new HashSet<>();

    /**
     * Constructor.
     */
    public Brands() {
    }

    /**
     * Constructor.
     *
     * @param aBrands a brand
     */
    public Brands(final String aBrands) {
        this.values = aBrands;
    }

    /**
     * Method to get.
     *
     * @return values
     */
    public final String getValues() {
        return this.values;
    }

    /**
     * Method to set.
     *
     * @param aValues a values
     **/
    public final void setValues(final String aValues) {
        this.values = aValues;
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
     * @return model
     */
    public final Set<Models> getModels() {
        return this.models;
    }

    /**
     * Method to set.
     *
     * @param aModels model
     **/
    public final void setModels(final Set<Models> aModels) {
        this.models = aModels;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Brands)) {
            return false;
        }
        final Brands brands = (Brands) o;
        return getId() == brands.getId()
                && getValues().equals(brands.getValues());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getValues());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Brands.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .add("models='" + this.models + "'")
                .toString();
    }
}
