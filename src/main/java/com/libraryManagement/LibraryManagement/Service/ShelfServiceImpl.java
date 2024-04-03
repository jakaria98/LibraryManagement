package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Shelf;
import com.libraryManagement.LibraryManagement.Repo.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    private ShelfRepository shelfRepository;

    @Override
    public Shelf createShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    @Override
    public Shelf getShelfById(String shelfId) {
        return shelfRepository.findById(shelfId).orElse(null);
    }

    @Override
    public void updateShelf(String shelfId, Shelf updatedShelf) {
        Shelf existingShelf = shelfRepository.findById(shelfId).orElse(null);
        if (existingShelf != null) {
            updatedShelf.setShelfId(shelfId);
            shelfRepository.save(updatedShelf);
        }
    }

    @Override
    public void deleteShelf(String shelfId) {
        shelfRepository.deleteById(shelfId);
    }
}
