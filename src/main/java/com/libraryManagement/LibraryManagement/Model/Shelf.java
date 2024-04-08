package com.libraryManagement.LibraryManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "shelves")
public class Shelf {
    @Id
    @NotEmpty(message = "Shelf ID is required")
    private String shelfId;
    @NotEmpty(message = "Genre is required")
    private String genre;
    private List<Book> books;

    // Constructor
    public Shelf(String shelfId, String genre) {
        this.shelfId = shelfId;
        this.genre = genre;
        this.books = new ArrayList<>();
    }

    // Getters and setters
    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Method to add a book to the shelf
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the shelf
    public void removeBook(Book book) {
        books.remove(book);
    }
}
