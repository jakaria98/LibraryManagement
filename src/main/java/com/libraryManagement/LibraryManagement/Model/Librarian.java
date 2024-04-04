package com.libraryManagement.LibraryManagement.Model;
import com.libraryManagement.LibraryManagement.Repo.UserRepository;

import java.util.List;

import java.util.List;
import java.util.Optional;

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

    public void manageUser(User user, UserRepository userRepository) {
        // Check if the user is already available
        Optional<User> existingUser = userRepository.findById(user.getUserID());

        if (existingUser.isPresent()) {
            // Update user details
            User updateUser = existingUser.get();
            updateUser.setName(user.getName());
            updateUser.setPassword(user.getPassword());
            updateUser.setEmailAddress(user.getEmailAddress());
            userRepository.save(updateUser); // Update existing user in the database
        } else {
            userRepository.save(user); // Add new user to the database
        }
    }
}
