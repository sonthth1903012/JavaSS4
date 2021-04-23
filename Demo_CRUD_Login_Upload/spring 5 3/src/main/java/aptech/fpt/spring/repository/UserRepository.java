package aptech.fpt.spring.repository;

import aptech.fpt.spring.model.User;
import aptech.fpt.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
