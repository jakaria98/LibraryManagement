package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Shelf;

public interface ShelfService {
    Shelf createShelf(Shelf shelf);
    Shelf getShelfById(String shelfId);
    void updateShelf(String shelfId, Shelf updatedShelf);
    void deleteShelf(String shelfId);
}
