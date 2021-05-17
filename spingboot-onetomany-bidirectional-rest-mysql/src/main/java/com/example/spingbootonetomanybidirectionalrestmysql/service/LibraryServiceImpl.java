package com.example.spingbootonetomanybidirectionalrestmysql.service;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Library;
import com.example.spingbootonetomanybidirectionalrestmysql.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public List<Library> getAll() {
        try{
            List<Library> list = libraryRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Library getById(int id) {
        try{
            Library library = libraryRepository.findById(id).get();
            return library;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createLibrary(Library library) {
        try{
            libraryRepository.save(library);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateLibrary(Library library) {
        try{
            libraryRepository.save(library);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteLibrary(int id) {
        try{
            Library library = libraryRepository.findById(id).get();
            libraryRepository.save(library);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
