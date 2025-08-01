package com.bookstore.repository;

import com.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Book Repository Interface
 * JpaRepository provides CRUD operations automatically
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Custom query methods (Spring Data JPA will implement automatically)
    List<Book> findByAuthor(String author);
    List<Book> findByTitleContaining(String title);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
}
