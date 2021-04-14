package com.example.jpamanytomanyprimarykey;

import com.example.jpamanytomanyprimarykey.model.Book;
import com.example.jpamanytomanyprimarykey.model.BookPublisher;
import com.example.jpamanytomanyprimarykey.model.Publisher;
import com.example.jpamanytomanyprimarykey.repository.BookPublisherRepository;
import com.example.jpamanytomanyprimarykey.repository.BookRepository;
import com.example.jpamanytomanyprimarykey.repository.PublisherRepository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JpaManyToManyPrimaryKeyApplication implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    BookPublisherRepository bookPublisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyPrimaryKeyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Book book1 = new Book("bookNo1");
//        Book book2 = new Book("bookNo2");
//        bookRepository.saveAll(Arrays.asList(book1,book2));
//
//        Publisher publisher1 = new Publisher("NYTimes");
//        Publisher publisher2 = new Publisher("Youth");
//        publisherRepository.saveAll(Arrays.asList(publisher1,publisher2));
//
//
    }
}
