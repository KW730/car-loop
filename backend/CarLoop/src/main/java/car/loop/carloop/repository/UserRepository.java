package car.loop.carloop.repository;

import car.loop.carloop.enums.UserRole;
import car.loop.carloop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUserRole(UserRole userRole);
}
