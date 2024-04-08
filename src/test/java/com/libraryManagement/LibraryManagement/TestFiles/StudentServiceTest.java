package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Student;
import com.libraryManagement.LibraryManagement.Repo.StudentRepository;
import com.libraryManagement.LibraryManagement.Service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void createStudentTest() {
        Student student = new Student("1", "Student Name", "password", "student@example.com", "STU123");
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student createdStudent = studentService.createStudent(student);
        assertEquals(student.getStudentId(), createdStudent.getStudentId());
    }

    // Here goes more tests for getStudentById, borrowBook, returnBook methods
}
