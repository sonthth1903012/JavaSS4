package com.example.spingbootonetomanybidirectionalrestmysql.repository;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
