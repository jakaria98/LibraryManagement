package com.libraryManagement.LibraryManagement.Repo;

import com.libraryManagement.LibraryManagement.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
