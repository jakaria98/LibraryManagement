package com.libraryManagement.LibraryManagement.Model;

import java.util.List;

import java.util.List;

public class Librarian extends User {
    private String employeeNumber;
    private List<Shelf> shelves;

    public Librarian(String userID, String name, String password, String emailAddress, String employeeNumber) {
        super(userID, name, password, emailAddress);
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public void addBook(Book book, Shelf shelf) {
        shelf.addBook(book);
    }

    public void editBook(String bookId, Book updatedBook) {
        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks()) {
                if (book.getBookID().equals(bookId)) {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setGenre(updatedBook.getGenre());
                    return;
                }
            }
        }
    }

    public void deleteBook(String bookId) {
        for (Shelf shelf : shelves) {
            shelf.getBooks().removeIf(book -> book.getBookID().equals(bookId));
        }
    }

    public void manageUser(String userId) {
        // Logic to manage user
    }
}
