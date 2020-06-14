package accident.repository;

import accident.model.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * AuthorityRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/14/2020
 */
public interface AuthorityRepository
        extends CrudRepository<Authority, Integer> {
    /**
     * Method to find.
     *
     * @param authority role
     * @return role
     */
    Authority findByAuthority(String authority);
}
