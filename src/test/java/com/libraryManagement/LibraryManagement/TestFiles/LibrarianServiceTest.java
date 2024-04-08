package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Librarian;
import com.libraryManagement.LibraryManagement.Repo.LibrarianRepository;
import com.libraryManagement.LibraryManagement.Service.LibrarianServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibrarianServiceTest {

    @Mock
    private LibrarianRepository librarianRepository;

    @InjectMocks
    private LibrarianServiceImpl librarianService;

    @Test
    public void createLibrarianTest() {
        Librarian librarian = new Librarian("1", "Librarian Name", "password", "librarian@example.com", "EMP123");
        when(librarianRepository.save(any(Librarian.class))).thenReturn(librarian);
        Librarian createdLibrarian = librarianService.createLibrarian(librarian);
        assertEquals(librarian.getEmployeeNumber(), createdLibrarian.getEmployeeNumber());
    }

    // Here goes more tests for methods like getLibrarianById, updateLibrarian, deleteLibrarian here
}
