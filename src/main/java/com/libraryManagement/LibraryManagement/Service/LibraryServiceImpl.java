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
            Library existingLibrary = libraryRepository.findById(libraryId).orElse(null);
            if (existingLibrary != null) {
                existingLibrary.setName(updatedLibrary.getName());
                existingLibrary.setAddress(updatedLibrary.getAddress());
                existingLibrary.setShelves(updatedLibrary.getShelves());
                libraryRepository.save(existingLibrary);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteLibrary(String libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
