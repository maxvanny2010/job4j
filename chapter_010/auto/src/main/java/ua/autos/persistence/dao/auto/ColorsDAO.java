package ua.autos.persistence.dao.auto;

import ua.autos.model.auto.Colors;
import ua.autos.persistence.dao.store.IStore;

/**
 * ColorDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
interface ColorsDAO extends IStore<Colors> {
    /**
     * Method to delete a color.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteColor();
}
