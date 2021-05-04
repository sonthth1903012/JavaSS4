package com.example.jpademo;

import com.example.jpademo.jpa.Book;
import com.example.jpademo.jpa.Publisher;
import com.example.jpademo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class JpademoApplication implements CommandLineRunner {

    @Bean
    public Docket Swagger(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }



    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpademoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        bookRepository.save(new Book("JpaBook",
                new Publisher("Pubilsher1"),
                new Publisher("puvbisher2")))
        ;
    }

}
