package ua.nino.model.auto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Models.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
@Entity
@Table(name = "models")
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model")
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

    /**
     * Method to get.
     *
     * @return a brands
     */
    @ManyToOne()
    @JoinColumn(name = "brand_id",
            foreignKey = @ForeignKey(name = "brand_id_fk"),
            nullable = false)
    public Brands getBrands() {
        return this.brands;
    }

    /**
     * Method to set.
     *
     * @param aBrands a brands
     **/
    public void setBrands(final Brands aBrands) {
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
    public final String toString() {
        return new StringJoiner(", ",
                Models.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .toString();
    }
}
