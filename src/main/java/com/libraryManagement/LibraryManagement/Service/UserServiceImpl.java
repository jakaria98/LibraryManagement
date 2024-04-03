package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.User;
import com.libraryManagement.LibraryManagement.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void updateUser(String userId, User newUser) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setName(newUser.getName());
            existingUser.setPassword(newUser.getPassword());
            existingUser.setEmailAddress(newUser.getEmailAddress());
            userRepository.save(existingUser);
        }
    }


    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean login(String userID, String password) {
        Optional<User> user = userRepository.findById(userID);
        if (user != null) {
            return user.get().login(password);
        }
        return false;
    }
}
