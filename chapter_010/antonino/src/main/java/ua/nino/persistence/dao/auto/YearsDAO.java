package ua.nino.persistence.dao.auto;

import ua.nino.model.auto.Years;
import ua.nino.persistence.dao.store.IStore;

/**
 * YearsDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
interface YearsDAO extends IStore<Years> {
    /**
     * Method to delete a year.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteYear();
}
