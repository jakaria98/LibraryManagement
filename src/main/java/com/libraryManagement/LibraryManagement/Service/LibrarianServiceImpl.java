package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Librarian;
import com.libraryManagement.LibraryManagement.Repo.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibrarianServiceImpl implements LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Override
    public Librarian createLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    @Override
    public Librarian getLibrarianById(String librarianId) {
        Optional<Librarian> optionalLibrarian = librarianRepository.findById(librarianId);
        return optionalLibrarian.orElse(null);
    }

    @Override
    public void updateLibrarian(String librarianId, Librarian updatedLibrarian) {
        Optional<Librarian> optionalLibrarian = librarianRepository.findById(librarianId);
        if (optionalLibrarian.isPresent()) {
            Librarian existingLibrarian = optionalLibrarian.get();
            existingLibrarian.setEmployeeNumber(updatedLibrarian.getEmployeeNumber());
            existingLibrarian.setName(updatedLibrarian.getName());
            // Set other attributes as needed
            librarianRepository.save(existingLibrarian);
        }
    }

    @Override
    public void deleteLibrarian(String librarianId) {
        librarianRepository.deleteById(librarianId);
    }

    @Override
    public void manageUser(String librarianId, String userId) {

    }
}
