package com.example.jpademo.repository;

import com.example.jpademo.jpa.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
