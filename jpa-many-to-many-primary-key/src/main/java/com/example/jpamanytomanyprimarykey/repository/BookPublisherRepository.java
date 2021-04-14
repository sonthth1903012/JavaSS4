package com.example.jpamanytomanyprimarykey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<PublisherRepository, Integer> {
}
