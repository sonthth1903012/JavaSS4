package com.example.jpa_web_demo2.repository;

import com.example.jpa_web_demo2.model.BookPublisher;
import com.example.jpa_web_demo2.model.BookPublisherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, BookPublisherId> {

}
