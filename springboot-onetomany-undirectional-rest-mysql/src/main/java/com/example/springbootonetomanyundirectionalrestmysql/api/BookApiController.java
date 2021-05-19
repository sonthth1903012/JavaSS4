package com.example.springbootonetomanyundirectionalrestmysql.api;

import com.example.springbootonetomanyundirectionalrestmysql.jpa.Book;
import com.example.springbootonetomanyundirectionalrestmysql.jpa.Library;
import com.example.springbootonetomanyundirectionalrestmysql.repository.BookRepository;
import com.example.springbootonetomanyundirectionalrestmysql.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookApiController {
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookApiController (LibraryRepository libraryRepository, BookRepository bookRepository){
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getAllBook(Pageable pageable){
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(!optionalBook.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalBook.get());
    }


    @GetMapping("/library/{libraryId}")
    public ResponseEntity<Page<Book>> getByLibraryId(@PathVariable Integer libraryId, Pageable pageable){
        return ResponseEntity.ok(libraryRepository.findByLibraryId(libraryId,pageable));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book){
        Optional<Library> optionalLibrary = libraryRepository
                .findById(book.getLibrary().getId());
        if(!optionalLibrary.isPresent()){
            return  ResponseEntity.unprocessableEntity().build();
        }
        book.setLibrary(optionalLibrary.get());
        Book bookSaved = bookRepository.save(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookSaved.getId()).toUri();
        return ResponseEntity.created(location).body(bookSaved);
    }



}
