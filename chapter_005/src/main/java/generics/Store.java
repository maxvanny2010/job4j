package generics;

/**
 * Store.
 *
 * @param <E> extend Base
 * @author Max Vanny.
 * @version 5.0
 * @since 0.1
 */
@SuppressWarnings("unused")
public interface Store<E extends Base> {
    /**
     * add.
     *
     * @param model model
     */
    void add(E model);

    /**
     * replace.
     *
     * @param id    id
     * @param model model
     */
    void replace(String id, E model);

    /**
     * delete.
     *
     * @param id id
     */
    void delete(String id);

    /**
     * findById.
     *
     * @param id id
     * @return T model
     */
    E findById(String id);
}

