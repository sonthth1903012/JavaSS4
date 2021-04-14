package com.example.jpa_web_demo2.repository;

import com.example.jpa_web_demo2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
