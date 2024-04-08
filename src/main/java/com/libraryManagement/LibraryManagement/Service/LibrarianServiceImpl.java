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
        return librarianRepository.findById(librarianId).orElse(null);
    }

    @Override
    public void updateLibrarian(String librarianId, Librarian updatedLibrarian) {
        Optional<Librarian> optionalLibrarian = librarianRepository.findById(librarianId);
        if (optionalLibrarian.isPresent()) {
            Librarian existingLibrarian = optionalLibrarian.get();
            existingLibrarian.setEmployeeNumber(updatedLibrarian.getEmployeeNumber());
            existingLibrarian.setName(updatedLibrarian.getName());
            existingLibrarian.setEmailAddress(updatedLibrarian.getEmailAddress());
            // Set shelves if needed, consider deep update or reference update strategies
            librarianRepository.save(existingLibrarian);
        }
    }

    @Override
    public void deleteLibrarian(String librarianId) {
        librarianRepository.deleteById(librarianId);
    }
}
