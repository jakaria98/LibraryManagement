package com.libraryManagement.LibraryManagement.Controller;

import com.libraryManagement.LibraryManagement.Model.Shelf;
import com.libraryManagement.LibraryManagement.Service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shelves")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;

    @PostMapping
    public ResponseEntity<Shelf> createShelf(@RequestBody Shelf shelf) {
        Shelf createdShelf = shelfService.createShelf(shelf);
        return new ResponseEntity<>(createdShelf, HttpStatus.CREATED);
    }

    @GetMapping("/{shelfId}")
    public ResponseEntity<Shelf> getShelfById(@PathVariable String shelfId) {
        Shelf shelf = shelfService.getShelfById(shelfId);
        if (shelf != null) {
            return new ResponseEntity<>(shelf, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{shelfId}")
    public ResponseEntity<Void> updateShelf(@PathVariable String shelfId, @RequestBody Shelf updatedShelf) {
        shelfService.updateShelf(shelfId, updatedShelf);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{shelfId}")
    public ResponseEntity<Void> deleteShelf(@PathVariable String shelfId) {
        shelfService.deleteShelf(shelfId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
