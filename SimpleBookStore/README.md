# Simple BookStore API - Spring Boot Project

A comprehensive Spring Boot REST API project demonstrating all key concepts with a simple Book Store application.

## 🎯 **Spring Boot Concepts Covered**

### ✅ **Spring Boot Basics**
- `@SpringBootApplication` - Main application class
- Auto-configuration and starter dependencies
- Embedded Tomcat server

### ✅ **REST API Annotations**
- `@RestController` - REST endpoints
- `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- `@PathVariable`, `@RequestBody`

### ✅ **Spring Boot Annotations**
- `@Component`, `@Service`, `@Repository`
- `@Autowired` for dependency injection

### ✅ **JPA & Hibernate**
- `@Entity`, `@Table`, `@Id`, `@GeneratedValue`
- `JpaRepository` with CRUD operations
- Custom query methods
- Auto DDL generation with `spring.jpa.hibernate.ddl-auto`

### ✅ **Database Configuration**
- H2 in-memory database for development
- `application.properties` configuration

### ✅ **Validation & Exception Handling**
- `@Valid`, `@NotNull`, `@NotBlank`, `@Positive`
- `@ControllerAdvice` for global exception handling

### ✅ **Spring Boot DevTools**
- Hot reload capability
- Enhanced development experience

## 🚀 **How to Run**

### Prerequisites
- Java 11+
- Maven 3.6+

### Commands

1. **Navigate to project:**
   ```bash
   cd simple-bookstore
   ```

2. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the API:**
   - Main API: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console

## 📋 **API Endpoints**

### **Basic Endpoints**
- `GET /` - Welcome message
- `GET /health` - Health check

### **Book CRUD Operations**
- `GET /api/books` - Get all books
- `GET /api/books/{id}` - Get book by ID
- `POST /api/books` - Create new book
- `PUT /api/books/{id}` - Update book
- `DELETE /api/books/{id}` - Delete book

### **Search Endpoints**
- `GET /api/books/search/author/{author}` - Find by author
- `GET /api/books/search/title/{title}` - Find by title

## 🧪 **Testing the API**

### **Sample JSON for POST/PUT:**
```json
{
  "title": "Spring Boot Guide",
  "author": "John Doe",
  "price": 29.99
}
```

### **Test Commands (using curl):**

**Get all books:**
```bash
curl http://localhost:8080/api/books
```

**Create a book:**
```bash
curl -X POST http://localhost:8080/api/books \
-H "Content-Type: application/json" \
-d '{"title":"Test Book","author":"Test Author","price":25.99}'
```

**Get book by ID:**
```bash
curl http://localhost:8080/api/books/1
```

## 🏗️ **Project Structure**
```
simple-bookstore/
├── src/main/java/com/bookstore/
│   ├── BookStoreApplication.java      # Main Spring Boot class
│   ├── model/
│   │   └── Book.java                  # JPA Entity
│   ├── repository/
│   │   └── BookRepository.java        # JPA Repository
│   ├── service/
│   │   └── BookService.java           # Business Logic
│   ├── controller/
│   │   ├── BookController.java        # REST Controller
│   │   └── HomeController.java        # Welcome endpoints
│   ├── exception/
│   │   └── GlobalExceptionHandler.java # Exception handling
│   └── config/
│       └── DataLoader.java            # Sample data loader
├── src/main/resources/
│   └── application.properties         # Configuration
└── pom.xml                           # Maven dependencies
```

## 📊 **Sample Data**
The application automatically loads sample books on startup:
- Java: The Complete Reference - Herbert Schildt - $45.99
- Spring Boot in Action - Craig Walls - $39.99
- Clean Code - Robert Martin - $42.50
- Effective Java - Joshua Bloch - $48.75
- Spring in Action - Craig Walls - $44.99

## 🔧 **Configuration Features**
- **Database**: H2 in-memory (auto-created on startup)
- **Logging**: DEBUG level for application, INFO for Spring
- **Validation**: Bean validation with custom error messages
- **Exception Handling**: Global error responses
- **DevTools**: Hot reload enabled for development

## 🎓 **Learning Outcomes**
This project demonstrates:
1. Spring Boot project setup and structure
2. REST API development with proper HTTP methods
3. JPA/Hibernate integration with H2 database
4. Bean validation and error handling
5. Service layer architecture
6. Configuration management
7. Sample data loading
8. Development tools usage

Perfect for learning Spring Boot fundamentals! 🚀
