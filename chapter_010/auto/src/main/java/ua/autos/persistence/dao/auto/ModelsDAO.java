package ua.autos.persistence.dao.auto;

import ua.autos.model.auto.Models;
import ua.autos.persistence.dao.store.IStore;

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
