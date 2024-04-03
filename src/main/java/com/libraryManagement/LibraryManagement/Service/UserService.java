package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(String userId);
    void updateUser(String userId, User newUser);
    void deleteUser(String userId);
    boolean login(String userId, String password);
}
