package accident.repository;

import java.util.List;

/**
 * IRepository.
 *
 * @param <T> type
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
public interface IRepository<T> {
    /**
     * Method to save.
     *
     * @param object a object
     * @return a object
     */
    @SuppressWarnings("unused")
    T save(T object);

    /**
     * Method to edit.
     *
     * @param object a object
     * @return a object
     */
    T update(T object);

    /**
     * Method to delete.
     *
     * @param object a object
     * @return a object
     */
    @SuppressWarnings("unused")
    T delete(T object);

    /**
     * Method to get.
     *
     * @param id id
     * @return a object
     */
    T get(int id);

    /**
     * Method to get.
     *
     * @return all object
     */
    List<T> getAll();
}
