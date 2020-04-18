package ua.autos.persistence.dao.ads;

import ua.autos.model.ads.Status;
import ua.autos.persistence.dao.store.IStore;

/**
 * StatusDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
interface StatusDAO extends IStore<Status> {
    /**
     * Method to delete a status.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteStatus();
}
