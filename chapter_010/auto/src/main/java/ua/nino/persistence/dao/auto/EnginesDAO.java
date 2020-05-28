package ua.nino.persistence.dao.auto;

import ua.nino.model.auto.Engines;
import ua.nino.persistence.dao.store.IStore;

/**
 * VolumesDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
interface EnginesDAO extends IStore<Engines> {
    /**
     * Method to delete a volume.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteVolume();
}
