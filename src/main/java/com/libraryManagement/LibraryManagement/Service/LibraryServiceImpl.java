package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Library;
import com.libraryManagement.LibraryManagement.Repo.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return libraryRepository.findById(libraryId).orElse(null);
    }

    @Override
    public boolean updateLibrary(String libraryId, Library updatedLibrary) {
        if (libraryRepository.existsById(libraryId)) {
            updatedLibrary.setName(libraryId); // This line should be corrected to: library.setName(updatedLibrary.getName());
            libraryRepository.save(updatedLibrary);
            return true;
        }
        return false;
    }

    @Override
    public void deleteLibrary(String libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
