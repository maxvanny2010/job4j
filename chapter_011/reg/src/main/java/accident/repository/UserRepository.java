package accident.repository;

import accident.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/11/2020
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Method to find user by user name.
     *
     * @param username user name
     * @return user
     */
    User findByUsername(String username);
}
