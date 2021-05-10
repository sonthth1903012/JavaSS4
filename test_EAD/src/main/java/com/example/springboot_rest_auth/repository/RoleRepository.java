package com.example.springboot_rest_auth.repository;

import com.example.springboot_rest_auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
