package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Librarian;
import com.libraryManagement.LibraryManagement.Repo.LibrarianRepository;
import com.libraryManagement.LibraryManagement.Service.LibrarianServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LibrarianServiceTest {

    @Mock
    private LibrarianRepository librarianRepository;

    @InjectMocks
    private LibrarianServiceImpl librarianService;

    private Librarian librarian;

    @BeforeEach
    void setUp() {
        // Initialize your Librarian object here
        librarian = new Librarian("1", "John Doe", "securepassword", "johndoe@example.com", "EMP001");
    }

    @Test
    void createLibrarian_ShouldSaveLibrarian() {
        when(librarianRepository.save(any(Librarian.class))).thenReturn(librarian);
        Librarian createdLibrarian = librarianService.createLibrarian(librarian);
        assertNotNull(createdLibrarian);
        assertEquals(librarian.getEmployeeNumber(), createdLibrarian.getEmployeeNumber());
    }

    @Test
    void getLibrarianById_ShouldReturnLibrarian() {
        when(librarianRepository.findById("1")).thenReturn(Optional.of(librarian));
        Librarian foundLibrarian = librarianService.getLibrarianById("1");
        assertNotNull(foundLibrarian);
        assertEquals(librarian.getEmployeeNumber(), foundLibrarian.getEmployeeNumber());
    }

    @Test
    void updateLibrarian_ShouldUpdateLibrarianDetails() {
        Librarian updatedLibrarian = new Librarian(librarian.getUserID(), "Jane Doe", librarian.getPassword(), librarian.getEmailAddress(), librarian.getEmployeeNumber());
        when(librarianRepository.findById("1")).thenReturn(Optional.of(librarian));
        when(librarianRepository.save(any(Librarian.class))).thenReturn(updatedLibrarian);
        librarianService.updateLibrarian(librarian.getUserID(), updatedLibrarian);
        assertEquals("Jane Doe", updatedLibrarian.getName());
    }

    @Test
    void deleteLibrarian_ShouldRemoveLibrarian() {
//        when(librarianRepository.findById("1")).thenReturn(Optional.of(librarian));
        doNothing().when(librarianRepository).deleteById("1");
        librarianService.deleteLibrarian("1");
        verify(librarianRepository, times(1)).deleteById("1");
    }
}
