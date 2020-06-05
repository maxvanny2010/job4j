package accident.repository;

import accident.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * AccidentMem.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Repository
public class AccidentMem {
    /**
     * field a store of accidents.
     */
    private final Map<Integer, Accident> accidents = new LinkedHashMap<>();

    /**
     * Method to add.
     *
     * @param accident a accident
     */
    public final void add(final Accident accident) {
        this.accidents.putIfAbsent(accident.getId(), accident);
    }

    /**
     * Method to delete.
     *
     * @param accident a accident
     */
    public final void deleteBy(final Accident accident) {
        this.accidents.values().removeAll(Collections.singleton(accident));
    }

    /**
     * Method to get.
     *
     * @param id a id
     * @return all accident
     */
    public final Accident get(final int id) {
        return this.accidents.getOrDefault(id, null);
    }

    /**
     * Method to update.
     *
     * @param accident a accident
     */
    public final void update(final Accident accident) {
        this.accidents.computeIfPresent(accident.getId(),
                (k, v) -> v = accident);
    }

    /**
     * Method to get.
     *
     * @return all accident
     */
    public final Map<Integer, Accident> getAll() {
        return this.accidents;
    }

    /**
     * Method to clear a store.
     */
    public final void clear() {
        this.accidents.clear();
    }
}
