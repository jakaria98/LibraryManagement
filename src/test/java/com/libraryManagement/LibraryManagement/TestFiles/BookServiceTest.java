package com.libraryManagement.LibraryManagement.TestFiles;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Repo.BookRepository;
import com.libraryManagement.LibraryManagement.Service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void createBookTest() {
        Book book = new Book("1", "Book Title", "Author Name", "Genre", true);
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book createdBook = bookService.createBook(book);
        assertEquals(book.getBookID(), createdBook.getBookID());
    }

    // Here goes more tests for getBookById, updateBook, deleteBook methods
}
