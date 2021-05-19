package com.example.springbootonetomanyundirectionalrestmysql.repository;

import com.example.springbootonetomanyundirectionalrestmysql.jpa.Book;
import com.example.springbootonetomanyundirectionalrestmysql.jpa.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    Page<Book> findByLibraryId(Integer library, Pageable pageable);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.library.id=?1 ")
    void deleteByLibraryId(Integer libraryId);

}
