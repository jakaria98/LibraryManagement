package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Library;
import com.libraryManagement.LibraryManagement.Model.Student;
import com.libraryManagement.LibraryManagement.Repo.LibraryRepository;
import com.libraryManagement.LibraryManagement.Service.LibraryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock
    private LibraryRepository libraryRepository;

    @Captor
    private ArgumentCaptor<Library> libraryArgumentCaptor;

    @InjectMocks
    private LibraryServiceImpl libraryService;

    private Library library;

    @BeforeEach
    void setUp() {
        // Initialize your Library object here
        library = new Library("Library Name", "Library Address");
    }

    @Test
    void createLibrary_ShouldSaveLibrary() {
        when(libraryRepository.save(any(Library.class))).thenReturn(library);
        Library createdLibrary = libraryService.createLibrary(library);
        assertNotNull(createdLibrary);
        assertEquals(library.getName(), createdLibrary.getName());
    }

    @Test
    void getLibraryById_ShouldReturnLibrary() {
        when(libraryRepository.findById("1")).thenReturn(Optional.of(library));
        Library foundLibrary = libraryService.getLibraryById("1");
        assertNotNull(foundLibrary);
        assertEquals(library.getName(), foundLibrary.getName());
    }

    @Test
    void updateLibrary_ShouldUpdateLibraryDetails() {
        Library updatedLibrary = new Library("Updated Library Name", "Updated Address");
        when(libraryRepository.findById("1")).thenReturn(Optional.of(library));
        when(libraryRepository.save(any(Library.class))).thenReturn(updatedLibrary);

        boolean updated = libraryService.updateLibrary("1", updatedLibrary);
        assertTrue(updated);
        verify(libraryRepository).save(libraryArgumentCaptor.capture());
        Library savedLibrary = libraryArgumentCaptor.getValue();

        assertEquals("Updated Library Name", savedLibrary.getName());
        assertEquals("Updated Address", savedLibrary.getAddress());
    }

    @Test
    void deleteLibrary_ShouldRemoveLibrary() {
        when(libraryRepository.existsById("1")).thenReturn(true);
        doNothing().when(libraryRepository).deleteById("1");
        libraryService.deleteLibrary("1");
        verify(libraryRepository, times(1)).deleteById("1");
    }
}
