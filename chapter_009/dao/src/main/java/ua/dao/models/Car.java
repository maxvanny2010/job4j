package ua.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Car.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/31/2020
 */
@Entity
@Table(name = "car")
public class Car {
    /**
     * field id.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * field a model.
     */
    @Column(name = "brand")
    private String brand;

    /**
     * field a types of model.
     */
    @Column(name = "model")
    private String model;

    /**
     * field a drivers.
     */
    @ManyToMany(mappedBy = "cars")
    private Set<Driver> drivers = new HashSet<>();
    /**
     * field a engine.
     */
    @ManyToOne
    @JoinColumn(name = "engine_id",
            foreignKey = @ForeignKey(name = "engine_id_fk"))
    private Engine engine;

    /**
     * Constructor.
     */
    public Car() {
    }

    /**
     * Constructor.
     *
     * @param aBrand  a brand
     * @param aModel  a model
     * @param aEngine a engine
     */
    public Car(final String aBrand, final String aModel, final Engine aEngine) {
        this.brand = aBrand;
        this.model = aModel;
        this.engine = aEngine;

    }

    /**
     * Constructor.
     *
     * @param aId     a id
     * @param aBrand  a brand
     * @param aModel  a model
     * @param aEngine a engine
     */
    public Car(final int aId, final String aBrand,
               final String aModel, final Engine aEngine) {
        this.id = aId;
        this.brand = aBrand;
        this.model = aModel;
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
    @SuppressWarnings("unused")
    public final void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return a engine
     */
    public final Engine getEngine() {
        return this.engine;
    }

    /**
     * Method to set.
     *
     * @param aEngine a engine
     **/
    @SuppressWarnings("unused")
    public final void setEngine(final Engine aEngine) {
        this.engine = aEngine;
    }

    /**
     * Method to get.
     *
     * @return a brand of car
     */
    public final String getBrand() {
        return this.brand;
    }

    /**
     * Method to set.
     *
     * @param aBrand a brand
     **/
    @SuppressWarnings("unused")
    public final void setBrand(final String aBrand) {
        this.brand = aBrand;
    }

    /**
     * Method to get.
     *
     * @return a model
     */
    public final String getModel() {
        return this.model;
    }

    /**
     * Method to set.
     *
     * @param aModel a model
     **/
    public final void setModel(final String aModel) {
        this.model = aModel;
    }

    /**
     * Method to get.
     *
     * @return drivers
     */
    @SuppressWarnings("unused")
    public final Set<Driver> getDrivers() {
        return this.drivers;
    }

    /**
     * Method to set.
     *
     * @param aDrivers a drivers
     **/
    @SuppressWarnings("unused")
    public final void setDrivers(final Set<Driver> aDrivers) {
        this.drivers = aDrivers;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        final Car car = (Car) o;
        return getId() == car.getId()
                && getBrand().equals(car.getBrand())
                && getModel().equals(car.getModel())
                && getEngine().equals(car.getEngine());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(),
                getEngine());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Car.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("brand='" + this.brand + "'")
                .add("model='" + this.model + "'")
                .add("engine='" + this.engine + "'")
                .toString();
    }
}
