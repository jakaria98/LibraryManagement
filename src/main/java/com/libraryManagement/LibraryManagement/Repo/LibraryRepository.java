package com.libraryManagement.LibraryManagement.Repo;

import com.libraryManagement.LibraryManagement.Model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {
}
