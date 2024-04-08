package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Model.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(String studentId);
    void borrowBook(String studentId, Book book);
    void returnBook(String studentId, Book book);
}
