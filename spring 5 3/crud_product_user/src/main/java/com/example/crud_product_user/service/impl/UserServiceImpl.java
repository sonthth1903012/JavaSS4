package t1907m.springboot_crud_product_user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import t1907m.springboot_crud_product_user.model.User;
import t1907m.springboot_crud_product_user.repository.UserRepository;
import t1907m.springboot_crud_product_user.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(User userNew) {
        User user = new User(userNew.getUsername(),
                passwordEncoder.encode(userNew.getPassword()),
                userNew.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = userRepository.findAll();

        return list;
    }

    @Override
    public User getUserById(long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }
}
