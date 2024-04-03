package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Librarian;
import org.springframework.stereotype.Service;

@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Override
    public Librarian createLibrarian(Librarian librarian) {
        // Implement logic to create librarian
        return null;
    }

    @Override
    public Librarian getLibrarianById(String librarianId) {
        // Implement logic to get librarian by ID
        return null;
    }

    @Override
    public void updateLibrarian(String librarianId, Librarian updatedLibrarian) {
        // Implement logic to update librarian
    }

    @Override
    public void deleteLibrarian(String librarianId) {
        // Implement logic to delete librarian
    }
}
