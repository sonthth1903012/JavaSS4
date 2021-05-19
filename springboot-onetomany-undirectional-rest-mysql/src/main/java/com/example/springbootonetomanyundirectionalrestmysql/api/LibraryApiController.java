package com.example.springbootonetomanyundirectionalrestmysql.api;

import com.example.springbootonetomanyundirectionalrestmysql.jpa.Library;
import com.example.springbootonetomanyundirectionalrestmysql.repository.BookRepository;
import com.example.springbootonetomanyundirectionalrestmysql.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryApiController {
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryApiController (LibraryRepository libraryRepository, BookRepository bookRepository){
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Library> createLibrary(@Valid @RequestBody Library library){
        Library librarySaved = libraryRepository.save(library);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(librarySaved.getId())
                .toUri();
        return ResponseEntity.created(location).body(librarySaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Library> deleteLibrary(@PathVariable Integer id){
        //check existed library
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if(!optionalLibrary.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        deleteLibraryCustomTransactional(optionalLibrary.get());
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public void deleteLibraryCustomTransactional(Library library){
        libraryRepository.deleteByLibraryId(library.getId());
        libraryRepository.delete(library);
    }

    @GetMapping("/")
    public ResponseEntity<Page<Library>> getAll(Pageable pageable){
        return ResponseEntity.ok(libraryRepository.findAll(pageable));
    }

}
