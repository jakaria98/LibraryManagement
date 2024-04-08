package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Model.Library;
import com.libraryManagement.LibraryManagement.Repo.BookRepository;
import com.libraryManagement.LibraryManagement.Service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Captor
    private ArgumentCaptor<Book> bookArgumentCaptor;
    @InjectMocks
    private BookServiceImpl bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize your Book object here
        book = new Book("1", "Effective Java", "Joshua Bloch", "Programming", true);
    }

    @Test
    void createBook_ShouldSaveBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book createdBook = bookService.createBook(book);
        assertNotNull(createdBook);
        assertEquals(book.getBookID(), createdBook.getBookID());
    }

    @Test
    void getBookById_ShouldReturnBook() {
        when(bookRepository.findById("1")).thenReturn(Optional.of(book));
        Book foundBook = bookService.getBookById("1");
        assertNotNull(foundBook);
        assertEquals(book.getBookID(), foundBook.getBookID());
    }

    @Test
    void updateBook_ShouldUpdateBookDetails() {
        Book updatedBook = new Book(book.getBookID(), "Clean Code", "Robert C. Martin", "Software Engineering", true);
        when(bookRepository.findById("1")).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        bookService.updateBook("1", updatedBook);
        verify(bookRepository).save(bookArgumentCaptor.capture());
        Book savedBook = bookArgumentCaptor.getValue();

        assertEquals("Clean Code", savedBook.getTitle());
        assertEquals("Robert C. Martin", savedBook.getAuthor());
    }

    @Test
    void deleteBook_ShouldRemoveBook() {
//        when(bookRepository.existsById("1")).thenReturn(true);
        doNothing().when(bookRepository).deleteById("1");

        bookService.deleteBook("1");
        verify(bookRepository, times(1)).deleteById("1");
    }
}
