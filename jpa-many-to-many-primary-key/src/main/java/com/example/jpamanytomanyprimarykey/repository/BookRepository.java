package com.example.jpamanytomanyprimarykey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookRepository, Integer> {
}
