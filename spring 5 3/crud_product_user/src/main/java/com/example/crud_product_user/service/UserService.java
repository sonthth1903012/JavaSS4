package t1907m.springboot_crud_product_user.service;

import t1907m.springboot_crud_product_user.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
    List<User> getAllUser();
    User getUserById(long id);
    boolean updateUser(User user);
}
