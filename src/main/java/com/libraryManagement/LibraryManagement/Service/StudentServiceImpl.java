package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Model.Student;
import com.libraryManagement.LibraryManagement.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<Book> searchBook(String keyword, List<Book> availableBooks) {
        // Implement searchBook logic from the Student class here if needed
        return null;
    }

    @Override
    public void borrowBook(String studentId, Book book) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.borrowBook(book);
            studentRepository.save(student);
        }
    }

    @Override
    public void returnBook(String studentId, Book book) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.returnBook(book);
            studentRepository.save(student);
        }
    }
}
