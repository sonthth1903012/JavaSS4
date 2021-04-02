package t1907m.springboot_crud_product_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1907m.springboot_crud_product_user.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
