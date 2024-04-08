package com.libraryManagement.LibraryManagement.Controller;

import com.libraryManagement.LibraryManagement.Model.Librarian;
import com.libraryManagement.LibraryManagement.Service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @PostMapping
    public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian) {
        Librarian createdLibrarian = librarianService.createLibrarian(librarian);
        return new ResponseEntity<>(createdLibrarian, HttpStatus.CREATED);
    }

    @GetMapping("/{librarianId}")
    public ResponseEntity<Librarian> getLibrarianById(@PathVariable String librarianId) {
        Librarian librarian = librarianService.getLibrarianById(librarianId);
        return librarian != null ? new ResponseEntity<>(librarian, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{librarianId}")
    public ResponseEntity<Void> updateLibrarian(@PathVariable String librarianId, @RequestBody Librarian updatedLibrarian) {
        librarianService.updateLibrarian(librarianId, updatedLibrarian);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{librarianId}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable String librarianId) {
        librarianService.deleteLibrarian(librarianId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
