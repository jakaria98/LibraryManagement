package com.libraryManagement.LibraryManagement.Model;
import javax.validation.constraints.NotEmpty;

public class Book {
    @NotEmpty(message = "Book ID is required")
    private String bookID;
    @NotEmpty(message = "Title is required")
    private String title;
    @NotEmpty(message = "Author is required")
    private String author;
    @NotEmpty(message = "Genre is required")
    private String genre;
    private boolean availabilityStatus;

    public Book(String bookID, String title, String author, String genre, boolean availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

}
