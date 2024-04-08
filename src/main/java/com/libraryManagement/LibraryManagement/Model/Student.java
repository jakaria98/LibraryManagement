package com.libraryManagement.LibraryManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "student")
public class Student extends User {
    @Id
    @NotEmpty(message = "Student ID is required")
    private String studentId;
    private List<Book> borrowedBooks;

    public Student(String userId, String name, String password, String emailAddress, String studentId) {
        super(userId, name, password, emailAddress);
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<Book> searchBook(String keyword, List<Book> availableBooks) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : availableBooks) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailabilityStatus(false);
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailabilityStatus(true);
        }
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }
}
