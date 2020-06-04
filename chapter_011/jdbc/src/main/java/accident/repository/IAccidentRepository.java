package accident.repository;

import accident.model.Accident;

import java.util.List;

/**
 * IAccidentRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
public interface IAccidentRepository {
    /**
     * Method to save.
     *
     * @param accident a accident
     * @return a accident
     */
    Accident save(Accident accident);

    /**
     * Method to edit.
     *
     * @param accident a accident
     * @return a accident
     */
    Accident edit(Accident accident);

    /**
     * Method to delete.
     *
     * @param accident a accident
     * @return a accident
     */
    Accident delete(Accident accident);

    /**
     * Method to get.
     *
     * @param value a accident
     * @return a accident
     */
    Accident get(Accident value);

    /**
     * Method to get.
     *
     * @return all accident
     */
    List<Accident> getAll();
}
