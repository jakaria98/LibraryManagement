package com.libraryManagement.LibraryManagement.Model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
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
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
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
            book.isAvailable();
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
