package com.example.springboot_rest_auth.repository;

import com.example.springboot_rest_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
