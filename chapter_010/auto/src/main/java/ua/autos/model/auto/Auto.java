package ua.autos.model.auto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
     * @return a brand
     */
    public final Brands getBrand() {
        return this.brand;
    }

    /**
     * Method to set.
     *
     * @param aBrand a brand
     **/
    public final void setBrand(final Brands aBrand) {
        this.brand = aBrand;
    }

    /**
     * Method to get.
     *
     * @return a model
     */
    public final Models getModel() {
        return this.model;
    }

    /**
     * Method to set.
     *
     * @param aModel a model
     **/
    public final void setModel(final Models aModel) {
        this.model = aModel;
    }

    /**
     * Method to get.
     *
     * @return a color
     */
    public final Colors getColor() {
        return this.color;
    }

    /**
     * Method to set.
     *
     * @param aColor a color
     **/
    public final void setColor(final Colors aColor) {
        this.color = aColor;
    }

    /**
     * Method to get.
     *
     * @return a engine
     */
    public final Engines getEngine() {
        return this.engine;
    }

    /**
     * Method to set.
     *
     * @param aEngine a engine
     **/
    public final void setEngine(final Engines aEngine) {
        this.engine = aEngine;
    }

    /**
     * Method to get.
     *
     * @return a year
     */
    public final Years getYear() {
        return this.year;
    }

    /**
     * Method to set.
     *
     * @param aYear a year
     **/
    public final void setYear(final Years aYear) {
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
    public final java.lang.String toString() {
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
