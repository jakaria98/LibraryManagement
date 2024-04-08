package com.libraryManagement.LibraryManagement.Controller;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Model.Student;
import com.libraryManagement.LibraryManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId) {
        Student student = studentService.getStudentById(studentId);
        return student != null ? new ResponseEntity<>(student, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{studentId}/borrow")
    public ResponseEntity<Void> borrowBook(@PathVariable String studentId, @RequestBody Book book) {
        studentService.borrowBook(studentId, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{studentId}/return")
    public ResponseEntity<Void> returnBook(@PathVariable String studentId, @RequestBody Book book) {
        studentService.returnBook(studentId, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
