package ua.nino.persistence.dao.auto;

import ua.nino.model.auto.Colors;
import ua.nino.persistence.dao.store.IStore;

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
