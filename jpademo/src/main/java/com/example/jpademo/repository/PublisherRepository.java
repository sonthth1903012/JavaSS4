package com.example.jpademo.repository;

import com.example.jpademo.jpa.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
