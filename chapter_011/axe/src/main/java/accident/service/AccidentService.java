package accident.service;

import accident.model.Accident;
import accident.repository.AccidentMem;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * AccidentService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Service
public class AccidentService {
    /**
     * field of a store.
     */
    private final AccidentMem mem;

    /**
     * Constructor.
     *
     * @param aMem a store of memory
     */
    public AccidentService(final AccidentMem aMem) {
        this.mem = aMem;
    }

    /**
     * Method to add.
     *
     * @param accident a accident
     **/
    public final void addAccident(final Accident accident) {
        this.mem.add(accident);
    }

    /**
     * Method to update.
     *
     * @param accident a accident
     **/
    public final void updateAccident(final Accident accident) {
        this.mem.update(accident);
    }

    /**
     * Method to get.
     *
     * @param id a id
     * @return accident
     **/
    public final Accident getAccident(final int id) {
        return this.mem.get(id);
    }

    /**
     * Method to delete.
     *
     * @param accident a accident
     **/
    public final void deleteByAccident(final Accident accident) {
        this.mem.deleteBy(accident);
    }

    /**
     * Method to get.
     *
     * @return all accident
     */
    public final Map<Integer, Accident> getAllAccidents() {
        return this.mem.getAll();
    }

    /**
     * Method to clear.
     */
    public final void clearStore() {
        this.mem.clear();
    }
}
