package com.libraryManagement.LibraryManagement.Controller;

import com.libraryManagement.LibraryManagement.Model.Library;
import com.libraryManagement.LibraryManagement.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library createdLibrary = libraryService.createLibrary(library);
        return new ResponseEntity<>(createdLibrary, HttpStatus.CREATED);
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<Library> getLibraryById(@PathVariable String libraryId) {
        Library library = libraryService.getLibraryById(libraryId);
        if (library != null) {
            return new ResponseEntity<>(library, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{libraryId}")
    public ResponseEntity<Void> updateLibrary(@PathVariable String libraryId, @RequestBody Library updatedLibrary) {
        libraryService.updateLibrary(libraryId, updatedLibrary);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable String libraryId) {
        libraryService.deleteLibrary(libraryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
