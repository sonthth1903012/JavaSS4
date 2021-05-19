package com.example.springbootonetomanyundirectionalrestmysql.dto;

import com.example.springbootonetomanyundirectionalrestmysql.jpa.Library;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface LibraryMapper {
    LibraryDTO toLibraryDTO(Library library);
    List<LibraryDTO> toLibraryDTOs(List<Library> libraries);
    Library toLibrary(LibraryDTO libraryDTO);
}
