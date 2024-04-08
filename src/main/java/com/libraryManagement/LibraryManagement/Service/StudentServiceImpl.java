package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Model.Student;
import com.libraryManagement.LibraryManagement.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void borrowBook(String studentId, Book book) {
        Student student = getStudentById(studentId);
        if (student != null && book.isAvailable()) {
            student.borrowBook(book);
            studentRepository.save(student);
        }
    }

    @Override
    public void returnBook(String studentId, Book book) {
        Student student = getStudentById(studentId);
        if (student != null) {
            student.returnBook(book);
            studentRepository.save(student);
        }
    }
}
