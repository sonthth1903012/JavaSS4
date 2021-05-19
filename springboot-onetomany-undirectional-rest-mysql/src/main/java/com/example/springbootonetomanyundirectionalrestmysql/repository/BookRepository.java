package com.example.springbootonetomanyundirectionalrestmysql.repository;

import com.example.springbootonetomanyundirectionalrestmysql.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {

}
