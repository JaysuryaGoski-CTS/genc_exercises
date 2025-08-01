package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Book Service Class
 * Contains business logic
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
    // Create new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    
    // Update existing book
    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            return bookRepository.save(book);
        }
        return null;
    }
    
    // Delete book
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Search books by author
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    
    // Search books by title
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }
}
