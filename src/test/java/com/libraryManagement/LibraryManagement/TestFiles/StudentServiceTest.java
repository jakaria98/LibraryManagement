package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Model.Student;
import com.libraryManagement.LibraryManagement.Repo.StudentRepository;
import com.libraryManagement.LibraryManagement.Service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @Captor
    private ArgumentCaptor<Student> studentArgumentCaptor;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;
    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize your Student and Book objects here
        student = new Student("1", "Alice", "password123", "alice@example.com", "STU123");
        book = new Book("1", "Effective Java", "Joshua Bloch", "Programming", true);
    }

    @Test
    void createStudent_ShouldSaveStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student createdStudent = studentService.createStudent(student);
        assertNotNull(createdStudent);
        assertEquals(student.getStudentId(), createdStudent.getStudentId());
    }

    @Test
    void getStudentById_ShouldReturnStudent() {
        when(studentRepository.findById("1")).thenReturn(Optional.of(student));
        Student foundStudent = studentService.getStudentById("1");
        assertNotNull(foundStudent);
        assertEquals(student.getStudentId(), foundStudent.getStudentId());
    }

    @Test
    void borrowBook_ShouldAddBookToBorrowedBooks() {
        when(studentRepository.findById("1")).thenReturn(Optional.of(student));
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        studentService.borrowBook("1", book);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student savedStudent = studentArgumentCaptor.getValue();

        assertTrue(savedStudent.getBorrowedBooks().contains(book));
    }

    @Test
    void returnBook_ShouldRemoveBookFromBorrowedBooks() {
        // Assuming the book was already borrowed by the student
        student.borrowBook(book);

        when(studentRepository.findById("1")).thenReturn(Optional.of(student));
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        studentService.returnBook("1", book);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student savedStudent = studentArgumentCaptor.getValue();

        assertFalse(savedStudent.getBorrowedBooks().contains(book));
    }
}
