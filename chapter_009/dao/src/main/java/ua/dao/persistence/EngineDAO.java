package ua.dao.persistence;

import ua.dao.models.Engine;

/**
 * EngineDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/17/2020
 */
interface EngineDAO extends IStore<Engine> {
    /**
     * Method to add a engine.
     *
     * @param volume a volume of engine
     * @return a engine
     */
    Engine getEngineByVolume(String volume);

    /**
     * Method to add a engine.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteEngine();
}
