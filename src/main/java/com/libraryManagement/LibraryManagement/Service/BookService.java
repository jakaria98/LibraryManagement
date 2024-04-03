package com.libraryManagement.LibraryManagement.Service;

import com.libraryManagement.LibraryManagement.Model.Book;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(String bookId);
    void updateBook(String bookId, Book updatedBook);
    void deleteBook(String bookId);
}
