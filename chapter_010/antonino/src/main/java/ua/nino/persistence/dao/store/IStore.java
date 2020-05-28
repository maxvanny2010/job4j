package ua.nino.persistence.dao.store;

/**
 * IStore.
 *
 * @param <T> type
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public interface IStore<T> {
    /**
     * Method to get.
     *
     * @return a instance of store
     */
    Store getStore();

    /**
     * Method to save.
     *
     * @param object a object
     * @return the object is saved
     */
    int save(T object);

    /**
     * Method to update.
     *
     * @param object a object
     */
    void update(T object);

    /**
     * Method to find.
     *
     * @param id a id
     * @return the object by id
     */
    T getById(int id);

    /**
     * Method to delete.
     *
     * @param object a object
     */
    void delete(T object);
}
