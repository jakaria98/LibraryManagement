package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.User;
import com.libraryManagement.LibraryManagement.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        // Hash the password before saving the new user
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
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
            existingUser.setEmailAddress(newUser.getEmailAddress());
            // Hash the password before updating
            String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            existingUser.setPassword(hashedPassword);
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
        if (user.isPresent()) {
            return BCrypt.checkpw(password, user.get().getPassword());
        }
        return false;
    }
}
