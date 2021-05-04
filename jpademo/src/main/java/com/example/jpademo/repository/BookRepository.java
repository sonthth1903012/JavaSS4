package com.example.jpademo.repository;

import com.example.jpademo.jpa.Book;
import com.example.jpademo.jpa.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Integer> {
    // void save(Book jpaBook, Publisher pubilsher1, Publisher puvbisher2);
}
