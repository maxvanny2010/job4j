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
 * Years.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
@Entity
@Table(name = "years")
public class Years {
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
     * @param aYears a year
     */
    public Years(final String aYears) {
        this.values = aYears;
    }

    /**
     * Constructor.
     */
    public Years() {
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_year")
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
        if (!(o instanceof Years)) {
            return false;
        }
        final Years years = (Years) o;
        return getId() == years.getId()
                && getValues().equals(years.getValues());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getValues());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Years.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("values='" + this.values + "'")
                .toString();
    }
}
