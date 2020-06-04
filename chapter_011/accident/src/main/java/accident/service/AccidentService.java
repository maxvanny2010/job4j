package accident.service;

import accident.model.Accident;
import accident.repository.AccidentMem;
import org.springframework.stereotype.Service;

import java.util.List;
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
     * field a service.
     */
    private static final AccidentService SERVICE = new AccidentService();
    /**
     * field of a store.
     */
    private final AccidentMem mem = new AccidentMem();

    /**
     * Method to get.
     *
     * @return a instance of service
     */
    public static AccidentService getService() {
        return SERVICE;
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

    /**
     * Method to init a store.
     *
     * @param list a list
     */
    public final void initStore(final List<Accident> list) {
        this.mem.init(list);
    }


}
