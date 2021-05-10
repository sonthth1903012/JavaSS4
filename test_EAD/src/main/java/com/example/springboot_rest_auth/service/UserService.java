package com.example.springboot_rest_auth.service;

import com.example.springboot_rest_auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
