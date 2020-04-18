package ua.autos.model.auto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Models.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public class Models {
    /**
     * field a id.
     */
    private int id;

    /**
     * field a value of brand.
     */
    private String values;
    /**
     * field a ads.
     */
    @JsonIgnore
    private Brands brands;

    /**
     * Constructor.
     */
    public Models() {
    }

    /**
     * Constructor.
     *
     * @param aModels a model
     */
    public Models(final String aModels) {
        this.values = aModels;
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

    /**
     * Method to get.
     *
     * @return a brands
     */
    public final Brands getBrands() {
        return this.brands;
    }

    /**
     * Method to set.
     *
     * @param aBrands a brands
     **/
    public final void setBrands(final Brands aBrands) {
        this.brands = aBrands;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Models)) {
            return false;
        }
        final Models models = (Models) o;
        return getId() == models.getId()
                && getValues().equals(models.getValues());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getValues());
    }

    @Override
    public final java.lang.String toString() {
        return new StringJoiner(", ",
                Models.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .toString();
    }
}
