package ua.nino.persistence.dao.auto;

import ua.nino.model.auto.Auto;
import ua.nino.model.auto.Brands;
import ua.nino.persistence.dao.store.IStore;

import java.util.List;

/**
 * AutoDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public interface AutoDAO extends IStore<Auto> {
    /**
     * Method to find.
     *
     * @param value  a value
     * @param tClass a class by find
     * @return a auto by value
     */
    List<?> findByValue(String value, Class<?> tClass);

    /**
     * Method to find.
     *
     * @param value a value
     * @return a brand
     */
    Brands getModels(String value);

    /**
     * Method to find a id of auto.
     *
     * @param brand  a brand
     * @param model  a model
     * @param engine a engine
     * @param year   a year
     * @param color  a color
     * @return a id
     */
    List<Integer> findAutoId(String brand, String model,
                             String engine, String year, String color);
}
