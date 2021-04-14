package com.example.jpademo;

import com.example.jpademo.jpa.Book;
import com.example.jpademo.jpa.Publisher;
import com.example.jpademo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {


	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) { SpringApplication.run(JpademoApplication.class, args); }


	@Override
	public void run(String... args) throws Exception {
		bookRepository.save(new Book("JpaBook",
				new Publisher("Pubilsher1"),
				new Publisher("puvbisher2")))
				;
	}

}
