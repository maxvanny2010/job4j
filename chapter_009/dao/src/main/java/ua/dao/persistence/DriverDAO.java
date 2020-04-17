package ua.dao.persistence;

import ua.dao.models.Car;
import ua.dao.models.Driver;

import java.util.List;

/**
 * DriverDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/17/2020
 */
interface DriverDAO extends IStore<Driver> {
    /**
     * Method to get.
     *
     * @param name a name of driver
     * @return a driver
     */
    Driver getDriverByName(String name);

    /**
     * Method to get.
     *
     * @param name a name of driver
     * @return a driver
     */
    List<Car> getCarsByDriverName(String name);
}
