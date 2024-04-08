package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.User;
import com.libraryManagement.LibraryManagement.Repo.UserRepository;
import com.libraryManagement.LibraryManagement.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        // Setup a user object to use in tests
        user = new User("1", "Test User", "password", "user@example.com");
    }

    @Test
    void createUser_ShouldSaveUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        User createdUser = userService.createUser(user);
        assertNotNull(createdUser);
        assertEquals(user.getUserID(), createdUser.getUserID());
    }

    @Test
    void getUserById_ShouldReturnUser() {
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        User foundUser = userService.getUserById("1");
        assertNotNull(foundUser);
        assertEquals(user.getUserID(), foundUser.getUserID());
    }

    @Test
    void updateUser_ShouldUpdateUserDetails() {
        User updatedUser = new User(user.getUserID(), "Updated Name", user.getPassword(), user.getEmailAddress());
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);
        userService.updateUser(user.getUserID(), updatedUser);
        assertEquals("Updated Name", user.getName());
    }

    @Test
    void deleteUser_ShouldRemoveUser() {
//        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        doNothing().when(userRepository).deleteById("1");
        userService.deleteUser("1");
        verify(userRepository, times(1)).deleteById("1");
    }
}
