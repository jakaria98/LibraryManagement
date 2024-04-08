package com.libraryManagement.LibraryManagement.Model;
import com.libraryManagement.LibraryManagement.Repo.UserRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.List;

import java.util.List;
import java.util.Optional;

@Document(collection = "librarians")
public class Librarian extends User {
    @Id
    @NotEmpty(message = "Employee Number is required")
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
        Optional<User> existingUser = userRepository.findById(user.getUserID());

        if (existingUser.isPresent()) {
            User updateUser = existingUser.get();
            updateUser.setName(user.getName());
            updateUser.setPassword(user.getPassword());
            updateUser.setEmailAddress(user.getEmailAddress());
            userRepository.save(updateUser);
        } else {
            userRepository.save(user);
        }
    }
}
