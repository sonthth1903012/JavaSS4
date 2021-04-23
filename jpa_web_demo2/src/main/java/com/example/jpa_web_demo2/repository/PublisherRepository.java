package com.example.jpa_web_demo2.repository;

import com.example.jpa_web_demo2.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
