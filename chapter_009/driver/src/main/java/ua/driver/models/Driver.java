package ua.driver.models;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Driver.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/31/2020
 */
public class Driver {
    /**
     * field a id.
     */
    private int id;

    /**
     * field a name.
     */
    private String name;

    /**
     * field a cars.
     */
    private Set<Car> cars;

    /**
     * Constructor.
     */
    public Driver() {
    }

    /**
     * Constructor.
     *
     * @param aName a name
     * @param aCars a cars
     */
    public Driver(final String aName, final Set<Car> aCars) {
        this.name = aName;
        this.cars = aCars;
    }

    /**
     * Constructor.
     *
     * @param aId   a id
     * @param aName a name
     * @param aCars a cars
     */
    public Driver(final int aId, final String aName, final Set<Car> aCars) {
        this.id = aId;
        this.name = aName;
        this.cars = aCars;
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
     * @return a name of driver
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Method to set.
     *
     * @param aName a name
     **/
    public final void setName(final String aName) {
        this.name = aName;
    }

    /**
     * Method to get.
     *
     * @return cars
     */
    public final Set<Car> getCars() {
        return this.cars;
    }

    /**
     * Method to set.
     *
     * @param aCars a drivers
     **/
    public final void setCars(final Set<Car> aCars) {
        this.cars = aCars;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Driver)) {
            return false;
        }
        final Driver driver = (Driver) o;
        return getId() == driver.getId()
                && getName().equals(driver.getName())
                && getCars().equals(driver.getCars());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getName(), getCars());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Driver.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("name='" + this.name + "'")
                .add("cars='" + this.cars + "'")
                .toString();
    }
}
