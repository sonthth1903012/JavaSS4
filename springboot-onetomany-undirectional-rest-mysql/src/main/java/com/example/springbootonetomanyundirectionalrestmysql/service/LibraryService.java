package com.example.springbootonetomanyundirectionalrestmysql.service;

import com.example.springbootonetomanyundirectionalrestmysql.jpa.Library;
import com.example.springbootonetomanyundirectionalrestmysql.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LibraryService {
    private  final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> findAllLibrary(){
        return  libraryRepository.findAll();
    }

    public Library saveLibrary(Library library){ return libraryRepository.save(library); }

    public Optional<Library> findById(Integer id){
        return  libraryRepository.findById(id);
    }

    public void deleteById(Integer id){
        libraryRepository.deleteById(id);
    }
}
