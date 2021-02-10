package personal.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
