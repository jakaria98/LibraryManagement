package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Book;
import com.libraryManagement.LibraryManagement.Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void updateBook(String bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        if (existingBook != null) {
            // Update the book attributes
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setAvailabilityStatus(updatedBook.isAvailable());
            // Save the updated book
            bookRepository.save(existingBook);
        }
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }
}
