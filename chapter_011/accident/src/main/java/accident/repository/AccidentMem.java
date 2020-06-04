package accident.repository;

import accident.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
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
     * @param list a list
     */
    public final void init(final List<Accident> list) {
        list.forEach(a -> {
            if (!this.accidents.containsKey(a.getId())) {
                this.accidents.put(a.getId(), a);
            }
        });
    }

    /**
     * Method to add.
     *
     * @param accident a accident
     */
    public final void add(final Accident accident) {
        if (!this.accidents.containsKey(accident.getId())) {
            this.accidents.put(accident.getId(), accident);
        } else {
            throw new RuntimeException("key not empty");
        }
    }

    /**
     * Method to add.
     *
     * @param accident a accident
     */
    public final void deleteBy(final Accident accident) {
        this.accidents.values().removeAll(Collections.singleton(accident));
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
