package accident.repository;

import accident.model.Accident;
import org.springframework.data.repository.CrudRepository;

/**
 * AccidentRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
public interface AccidentRepository extends CrudRepository<Accident, Integer> {
}
