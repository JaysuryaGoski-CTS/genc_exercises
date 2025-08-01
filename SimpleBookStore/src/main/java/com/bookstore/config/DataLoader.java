package com.bookstore.config;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Data Loader to insert sample data on startup
 */
@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Insert sample books if database is empty
        if (bookRepository.count() == 0) {
            System.out.println("📚 Loading sample books...");
            
            bookRepository.save(new Book("Java: The Complete Reference", "Herbert Schildt", 45.99));
            bookRepository.save(new Book("Spring Boot in Action", "Craig Walls", 39.99));
            bookRepository.save(new Book("Clean Code", "Robert Martin", 42.50));
            bookRepository.save(new Book("Effective Java", "Joshua Bloch", 48.75));
            bookRepository.save(new Book("Spring in Action", "Craig Walls", 44.99));
            
            System.out.println("✅ Sample books loaded successfully!");
        }
    }
}
