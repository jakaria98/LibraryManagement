package com.libraryManagement.LibraryManagement.Repo;

import com.libraryManagement.LibraryManagement.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    // You can add custom methods here if needed
}
