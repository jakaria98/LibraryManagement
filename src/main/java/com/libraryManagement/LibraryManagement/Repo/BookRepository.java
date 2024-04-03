package com.libraryManagement.LibraryManagement.Repo;

import com.libraryManagement.LibraryManagement.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
