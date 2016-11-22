package fr.goui.dao;

import fr.goui.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The data access object for the User table.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
