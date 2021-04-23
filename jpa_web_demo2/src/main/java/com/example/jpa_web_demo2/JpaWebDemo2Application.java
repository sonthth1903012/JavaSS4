package com.example.jpa_web_demo2;

import com.example.jpa_web_demo2.model.Book;
import com.example.jpa_web_demo2.model.BookPublisher;
import com.example.jpa_web_demo2.model.Publisher;
import com.example.jpa_web_demo2.repository.BookPublisherRepository;
import com.example.jpa_web_demo2.repository.BookRepository;
import com.example.jpa_web_demo2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;


@SpringBootApplication
public class JpaWebDemo2Application implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    BookPublisherRepository bookPublisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaWebDemo2Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Book b1 = new Book("Al'z Zebrasiet");
        Book b2 = new Book("Willing for A Day");
        bookRepository.saveAll(Arrays.asList(b1, b2));

        Publisher p1 = new Publisher("Kim Dong");
        Publisher p2 = new Publisher("Nha Nam");
        publisherRepository.saveAll(Arrays.asList(p1, p2));

        BookPublisher bp1 = new BookPublisher(b1, p1, new Date());
        BookPublisher bp2 = new BookPublisher(b2, p2, new Date());
        bookPublisherRepository.saveAll(Arrays.asList(bp1, bp2));
    }

}
