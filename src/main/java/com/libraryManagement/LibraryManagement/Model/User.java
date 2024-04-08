package com.libraryManagement.LibraryManagement.Model;
import com.libraryManagement.LibraryManagement.Service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection = "users")
public class User {
    @Id
    @NotEmpty(message = "User ID is required")
    private String userID;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Password is required")
    private String password;
    @NotEmpty(message = "Email Address is required")
    private String emailAddress;

    // Constructor
    public User(String userID, String name, String password, String emailAddress) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    // Getters and setters
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // Additional methods
    public boolean login(String candidatePassword) {
        // Use BCrypt's checkpw method to verify the provided password against the hashed password
        return BCrypt.checkpw(candidatePassword, password);
    }

    public void updateProfile(User user, @NotNull UserService userService) {
        // Update the user's profile attributes
        this.name = user.getName();
        this.emailAddress= user.getEmailAddress();
        this.password= user.getPassword();
        // Call the service method to update the user's profile in the database
        userService.updateUser(user.getUserID(),this);
    }
}
