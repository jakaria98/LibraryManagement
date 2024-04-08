package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Library;
import com.libraryManagement.LibraryManagement.Repo.LibraryRepository;
import com.libraryManagement.LibraryManagement.Service.LibraryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock
    private LibraryRepository libraryRepository;

    @InjectMocks
    private LibraryServiceImpl libraryService;

    @Test
    public void createLibraryTest() {
        Library library = new Library("Library Name", "Library Address");
        when(libraryRepository.save(any(Library.class))).thenReturn(library);
        Library createdLibrary = libraryService.createLibrary(library);
        assertEquals(library.getName(), createdLibrary.getName());
    }

    // Here goes more tests for getLibraryById, updateLibrary, deleteLibrary methods
}
