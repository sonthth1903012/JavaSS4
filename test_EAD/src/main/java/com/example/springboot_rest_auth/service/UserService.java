package com.example.springboot_rest_auth.service;

import com.example.springboot_rest_auth.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> listUser();
}
