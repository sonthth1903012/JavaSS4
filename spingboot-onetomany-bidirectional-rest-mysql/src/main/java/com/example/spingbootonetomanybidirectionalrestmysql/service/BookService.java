package com.example.spingbootonetomanybidirectionalrestmysql.service;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getById(int id);
    boolean createBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(int id);
}
