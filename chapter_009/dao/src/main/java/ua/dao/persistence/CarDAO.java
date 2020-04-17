package ua.dao.persistence;

import ua.dao.models.Car;

import java.util.List;

/**
 * CarDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/17/2020
 */
interface CarDAO extends IStore<Car> {
    /**
     * Method to get.
     *
     * @param brand a id
     * @return a car by id
     */
    List<Car> getByBrand(String brand);
}
