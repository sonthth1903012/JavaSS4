package com.example.springbootonetomanyundirectionalrestmysql.service;

import com.example.springbootonetomanyundirectionalrestmysql.jpa.Book;
import com.example.springbootonetomanyundirectionalrestmysql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {
        private  final BookRepository bookRepository;

        public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        public List<Book> findAllBook(){
                return  bookRepository.findAll();
            }

        public Book saveBook(Book book){
            return bookRepository.save(book);
        }

        public Optional<Book> findById(Integer id){
            return  bookRepository.findById(id);
        }

        public void deleteById(Integer id){
            bookRepository.deleteById(id);
        }
}
