package aptech.fpt.spring.repository;

import aptech.fpt.spring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User,Long> {


}
