package com.example.spingbootonetomanybidirectionalrestmysql.repository;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
