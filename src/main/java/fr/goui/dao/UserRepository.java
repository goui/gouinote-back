package fr.goui.dao;

import fr.goui.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The data access object for the User table.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNicknameAndPassword(String nickname, String password);
}
