package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Shelf;
import com.libraryManagement.LibraryManagement.Repo.ShelfRepository;
import com.libraryManagement.LibraryManagement.Service.ShelfServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShelfServiceTest {

    @Mock
    private ShelfRepository shelfRepository;

    @InjectMocks
    private ShelfServiceImpl shelfService;

    @Test
    public void createShelfTest() {
        Shelf shelf = new Shelf("1", "Genre");
        when(shelfRepository.save(any(Shelf.class))).thenReturn(shelf);
        Shelf createdShelf = shelfService.createShelf(shelf);
        assertEquals(shelf.getShelfId(), createdShelf.getShelfId());
    }

    // Here goes more tests for getShelfById, updateShelf, deleteShelf methods
}
