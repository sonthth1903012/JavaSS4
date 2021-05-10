package com.example.springboot_rest_auth.service;

public interface SercurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
