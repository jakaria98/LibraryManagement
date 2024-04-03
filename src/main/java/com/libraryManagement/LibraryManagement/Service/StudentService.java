package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(String studentId);
    List<Book> searchBook(String keyword, List<Book> availableBooks);
    void borrowBook(String studentId, Book book);
    void returnBook(String studentId, Book book);
}
