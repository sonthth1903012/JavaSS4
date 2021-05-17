package com.example.spingbootonetomanybidirectionalrestmysql.api;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Library;
import com.example.spingbootonetomanybidirectionalrestmysql.repository.BookRepository;
import com.example.spingbootonetomanybidirectionalrestmysql.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/librarys")
public class LibraryApiController {
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryApiController(BookRepository bookRepository, LibraryRepository libraryRepository){
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Library>> getAll(Pageable pageable){
        return ResponseEntity.ok(libraryRepository.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable Integer id){
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if(!optionalLibrary.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalLibrary.get());
    }

    @PostMapping
    public ResponseEntity<Library> createLibrary(@Valid @RequestBody Library library){
        Library librarySaved = libraryRepository.save(library);

        //Check Header of Service
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(librarySaved)
                .toUri();
        return ResponseEntity.created(location).body(librarySaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Integer id,
                                                  @Valid
                                                @RequestBody Library library){
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if(!optionalLibrary.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        library.setId(optionalLibrary.get().getId());
        libraryRepository.save(library);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Library> deleteLibrary(@PathVariable Integer id){
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if(!optionalLibrary.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        libraryRepository.delete(optionalLibrary.get());
        return ResponseEntity.noContent().build();
    }

}
