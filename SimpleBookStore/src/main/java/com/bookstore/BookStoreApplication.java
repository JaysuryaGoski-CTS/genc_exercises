package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application Class
 * @SpringBootApplication combines @Configuration, @EnableAutoConfiguration, and @ComponentScan
 */
@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		System.out.println("📚 Starting Simple BookStore API...");
		SpringApplication.run(BookStoreApplication.class, args);
		System.out.println("🚀 BookStore API is running on http://localhost:8080");
	}
}
