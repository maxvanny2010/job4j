package ua.nino.persistence.dao.auto;

import ua.nino.model.auto.Models;
import ua.nino.persistence.dao.store.IStore;

/**
 * ModelsDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
interface ModelsDAO extends IStore<Models> {
    /**
     * Method to delete a model.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteModel();
}
