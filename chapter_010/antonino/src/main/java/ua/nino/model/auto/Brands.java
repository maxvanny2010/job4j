package ua.nino.model.auto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Entity
@Table(name = "brands")
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
    @Column(name = "values")
    public String getValues() {
        return this.values;
    }

    /**
     * Method to set.
     *
     * @param aValues a values
     **/
    public void setValues(final String aValues) {
        this.values = aValues;
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
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
     * @return model
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brands")
    public Set<Models> getModels() {
        return this.models;
    }

    /**
     * Method to set.
     *
     * @param aModels model
     **/
    public void setModels(final Set<Models> aModels) {
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
