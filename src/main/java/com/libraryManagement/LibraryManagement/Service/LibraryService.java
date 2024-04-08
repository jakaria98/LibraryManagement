package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Library;

public interface LibraryService {
    Library createLibrary(Library library);
    Library getLibraryById(String libraryId);
    boolean updateLibrary(String libraryId, Library updatedLibrary);
    void deleteLibrary(String libraryId);
}
