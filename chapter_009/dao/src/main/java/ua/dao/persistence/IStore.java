package ua.dao.persistence;

/**
 * IStore.
 *
 * @param <T> type
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/17/2020
 */
interface IStore<T> {

    /**
     * Method to get.
     *
     * @return a instance of store
     */
    Store getStore();

    /**
     * Method to save object to db.
     *
     * @param object a object
     * @return the save object
     */
    T save(T object);

    /**
     * Method to update object in db.
     *
     * @param object a object
     */
    void update(T object);

    /**
     * Method to delete object from db.
     *
     * @param object a object
     */
    void delete(T object);

    /**
     * Method to get.
     *
     * @param id     a id
     * @param tClass a required class
     * @return the instance by object
     */
    T getById(int id, Class<T> tClass);

    /**
     * Method to delete a table by name.
     *
     * @param name a name
     */
    void dropTable(String name);
}
