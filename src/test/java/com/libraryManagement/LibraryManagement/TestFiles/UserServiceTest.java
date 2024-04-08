package com.libraryManagement.LibraryManagement.TestFiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.libraryManagement.LibraryManagement.Model.User;
import com.libraryManagement.LibraryManagement.Repo.UserRepository;
import com.libraryManagement.LibraryManagement.Service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void createUserTest() {
        User user = new User("1", "Test User", "password", "user@example.com");
        when(userRepository.save(any(User.class))).thenReturn(user);
        User createdUser = userService.createUser(user);
        assertEquals(user.getUserID(), createdUser.getUserID());
    }

    @Test
    public void getUserByIdTest() {
        User user = new User("1", "Test User", "password", "user@example.com");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        User foundUser = userService.getUserById("1");
        assertEquals(user.getUserID(), foundUser.getUserID());
    }
    // Here goes more tests for other methods like updateUser, deleteUser, login here
}
