package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Library;
import com.libraryManagement.LibraryManagement.Model.Shelf;
import com.libraryManagement.LibraryManagement.Repo.ShelfRepository;
import com.libraryManagement.LibraryManagement.Service.ShelfServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShelfServiceTest {

    @Mock
    private ShelfRepository shelfRepository;

    @Captor
    private ArgumentCaptor<Shelf> shelfArgumentCaptor;

    @InjectMocks
    private ShelfServiceImpl shelfService;

    private Shelf shelf;

    @BeforeEach
    void setUp() {
        // Initialize your Shelf object here
        shelf = new Shelf("1", "Programming");
    }

    @Test
    void createShelf_ShouldSaveShelf() {
        when(shelfRepository.save(any(Shelf.class))).thenReturn(shelf);
        Shelf createdShelf = shelfService.createShelf(shelf);
        assertNotNull(createdShelf);
        assertEquals(shelf.getShelfId(), createdShelf.getShelfId());
    }

    @Test
    void getShelfById_ShouldReturnShelf() {
        when(shelfRepository.findById("1")).thenReturn(Optional.of(shelf));
        Shelf foundShelf = shelfService.getShelfById("1");
        assertNotNull(foundShelf);
        assertEquals(shelf.getShelfId(), foundShelf.getShelfId());
    }

    @Test
    void updateShelf_ShouldUpdateShelfDetails() {
        Shelf updatedShelf = new Shelf(shelf.getShelfId(), "Fiction");
        when(shelfRepository.findById("1")).thenReturn(Optional.of(shelf));
        when(shelfRepository.save(any(Shelf.class))).thenReturn(updatedShelf);

        shelfService.updateShelf("1", updatedShelf);
        verify(shelfRepository).save(shelfArgumentCaptor.capture());
        Shelf savedShelf = shelfArgumentCaptor.getValue();

        assertEquals("Fiction", savedShelf.getGenre());
    }

    @Test
    void deleteShelf_ShouldRemoveShelf() {
        when(shelfRepository.existsById("1")).thenReturn(true);
        doNothing().when(shelfRepository).deleteById("1");

        shelfService.deleteShelf("1");
        verify(shelfRepository, times(1)).deleteById("1");
    }
}
