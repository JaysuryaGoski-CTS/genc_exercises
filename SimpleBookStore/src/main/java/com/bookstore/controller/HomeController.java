package com.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Home Controller for basic API information
 */
@RestController
public class HomeController {
    
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "📚 Welcome to Simple BookStore API!");
        response.put("timestamp", LocalDateTime.now());
        response.put("endpoints", Map.of(
            "books", "/api/books",
            "h2-console", "/h2-console",
            "health", "/actuator/health"
        ));
        return response;
    }
    
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "BookStore API");
        return status;
    }
}
