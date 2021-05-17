package com.example.spingbootonetomanybidirectionalrestmysql.service;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Book;
import com.example.spingbootonetomanybidirectionalrestmysql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        try{
            List<Book> list = bookRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getById(int id) {
        try{
            Book book = bookRepository.findById(id).get();
            return book;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createBook(Book book) {
        try{
            bookRepository.save(book);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        try{
            bookRepository.save(book);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        try{
            Book book = bookRepository.findById(id).get();
            bookRepository.save(book);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
