package com.example.spingbootonetomanybidirectionalrestmysql.service;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Library;

import java.util.List;

public interface LibraryService {
    List<Library> getAll();
    Library getById(int id);
    boolean createLibrary(Library library);
    boolean updateLibrary(Library library);
    boolean deleteLibrary(int id);
}
