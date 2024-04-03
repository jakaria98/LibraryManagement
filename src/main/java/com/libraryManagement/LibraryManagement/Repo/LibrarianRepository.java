package com.libraryManagement.LibraryManagement.Repo;

import com.libraryManagement.LibraryManagement.Model.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends MongoRepository<Librarian, String> {
}
