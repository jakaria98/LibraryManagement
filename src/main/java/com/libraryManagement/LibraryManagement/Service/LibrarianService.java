package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Librarian;

public interface LibrarianService {
    Librarian createLibrarian(Librarian librarian);
    Librarian getLibrarianById(String librarianId);
    void updateLibrarian(String librarianId, Librarian updatedLibrarian);
    void deleteLibrarian(String librarianId);

    void manageUser(String librarianId, String userId);
}
