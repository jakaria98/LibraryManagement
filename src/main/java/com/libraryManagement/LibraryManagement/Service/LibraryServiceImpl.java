package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Library;
import com.libraryManagement.LibraryManagement.Repo.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library getLibraryById(String libraryId) {
        Optional<Library> libraryOptional = libraryRepository.findById(libraryId);
        return libraryOptional.orElse(null);
    }

    @Override
    public void updateLibrary(String libraryId, Library updatedLibrary) {
        if (libraryRepository.existsById(libraryId)) {
            updatedLibrary.setName(libraryId);
            libraryRepository.save(updatedLibrary);
        }
    }

    @Override
    public void deleteLibrary(String libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
