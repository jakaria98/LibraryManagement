package com.libraryManagement.LibraryManagement.Model;

import java.util.List;

public class Librarian extends User {
    private String employeeNumber;

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

    public void addBook(Book book, Shelf shelf) {
        shelf.addBook(book);
    }

    public void editBook(Book oldBook, Book newBook) {
        oldBook.setTitle(newBook.getTitle());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setGenre(newBook.getGenre());
    }

    public void deleteBook(Book book, Shelf shelf) {
        shelf.removeBook(book);
    }

    public void manageUsers(List<User> users) {
        // Logic to manage users

        }
    }
