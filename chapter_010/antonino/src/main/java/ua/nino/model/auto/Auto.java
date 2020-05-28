package ua.nino.model.auto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
 * Auto.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "auto")
public class Auto {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a brand.
     */
    private Brands brand;
    /**
     * field a model.
     */
    private Models model;

    /**
     * field a color.
     */
    private Colors color;
    /**
     * field a engine.
     */
    private Engines engine;
    /**
     * field a year.
     */
    private Years year;

    /**
     * Constructor.
     */
    public Auto() {
    }

    /**
     * Constructor.
     *
     * @param aBrand  a brand
     * @param aModel  a model
     * @param aColor  a color
     * @param aEngine a engine
     * @param aYear   a year
     */
    public Auto(final Brands aBrand, final Models aModel, final Engines aEngine,
                final Colors aColor, final Years aYear) {
        this.brand = aBrand;
        this.model = aModel;
        this.color = aColor;
        this.year = aYear;
        this.engine = aEngine;
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")
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
     * @return a brand
     */
    @ManyToOne()
    @JoinColumn(name = "brand_id",
            foreignKey = @ForeignKey(name = "brand_id_fk"),
            unique = true, nullable = false)
    public Brands getBrand() {
        return this.brand;
    }

    /**
     * Method to set.
     *
     * @param aBrand a brand
     **/
    public void setBrand(final Brands aBrand) {
        this.brand = aBrand;
    }

    /**
     * Method to get.
     *
     * @return a model
     */
    @ManyToOne()
    @JoinColumn(name = "model_id",
            foreignKey = @ForeignKey(name = "model_id_fk"),
            unique = true, nullable = false)
    public Models getModel() {
        return this.model;
    }

    /**
     * Method to set.
     *
     * @param aModel a model
     **/
    public void setModel(final Models aModel) {
        this.model = aModel;
    }

    /**
     * Method to get.
     *
     * @return a color
     */
    @ManyToOne()
    @JoinColumn(name = "color_id",
            foreignKey = @ForeignKey(name = "color_id_fk"),
            unique = true, nullable = false)
    public Colors getColor() {
        return this.color;
    }

    /**
     * Method to set.
     *
     * @param aColor a color
     **/
    public void setColor(final Colors aColor) {
        this.color = aColor;
    }

    /**
     * Method to get.
     *
     * @return a engine
     */
    @ManyToOne()
    @JoinColumn(name = "engine_id",
            foreignKey = @ForeignKey(name = "engine_id_fk"),
            unique = true, nullable = false)
    public Engines getEngine() {
        return this.engine;
    }

    /**
     * Method to set.
     *
     * @param aEngine a engine
     **/
    public void setEngine(final Engines aEngine) {
        this.engine = aEngine;
    }

    /**
     * Method to get.
     *
     * @return a year
     */
    @ManyToOne
    @JoinColumn(name = "year_id", foreignKey = @ForeignKey(name = "year_fk_id"),
            unique = true, nullable = false)
    public Years getYear() {
        return this.year;
    }

    /**
     * Method to set.
     *
     * @param aYear a year
     **/
    public void setYear(final Years aYear) {
        this.year = aYear;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Auto)) {
            return false;
        }
        final Auto auto = (Auto) o;
        return getId() == auto.getId()
                && getBrand().equals(auto.getBrand())
                && getModel().equals(auto.getModel())
                && getColor().equals(auto.getColor())
                && getEngine().equals(auto.getEngine())
                && getYear().equals(auto.getYear());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getBrand(),
                getModel(), getColor(), getEngine(), getYear());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ", Auto.class.getSimpleName()
                + "[", "]")
                .add("id=" + this.id)
                .add("brand=" + this.brand)
                .add("model=" + this.model)
                .add("engine=" + this.engine)
                .add("color=" + this.color)
                .add("year=" + this.year)
                .toString();
    }
}
