package SOLID_Principles;

// BAD EXAMPLE - Violates DIP (High-level module depends on low-level module)
class BadMySQLDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL database: " + data);
    }
    
    public String read(int id) {
        return "Data from MySQL with ID: " + id;
    }
}

class BadUserService {
    private BadMySQLDatabase database; // Direct dependency on concrete class
    
    public BadUserService() {
        this.database = new BadMySQLDatabase(); // Tight coupling
    }
    
    public void createUser(String userData) {
        // Business logic
        System.out.println("Processing user data: " + userData);
        database.save(userData);
    }
    
    public String getUser(int userId) {
        return database.read(userId);
    }
}

// GOOD EXAMPLE - Follows DIP (Depend on abstractions, not concretions)

// Abstraction (interface)
interface Database {
    void save(String data);
    String read(int id);
}

// Low-level modules (concrete implementations)
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL database: " + data);
    }
    
    @Override
    public String read(int id) {
        return "Data from MySQL with ID: " + id;
    }
}

class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to PostgreSQL database: " + data);
    }
    
    @Override
    public String read(int id) {
        return "Data from PostgreSQL with ID: " + id;
    }
}

class FileDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to file system: " + data);
    }
    
    @Override
    public String read(int id) {
        return "Data from file with ID: " + id;
    }
}

// High-level module depends on abstraction
class UserService {
    private Database database; // Dependency on interface, not concrete class
    
    // Dependency injection through constructor
    public UserService(Database database) {
        this.database = database;
    }
    
    public void createUser(String userData) {
        // Business logic remains the same
        System.out.println("Processing user data: " + userData);
        database.save(userData);
    }
    
    public String getUser(int userId) {
        return database.read(userId);
    }
}

// Notification example
interface NotificationService {
    void sendNotification(String message);
}

class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

class OrderService {
    private Database database;
    private NotificationService notificationService;
    
    public OrderService(Database database, NotificationService notificationService) {
        this.database = database;
        this.notificationService = notificationService;
    }
    
    public void processOrder(String orderData) {
        System.out.println("Processing order...");
        database.save(orderData);
        notificationService.sendNotification("Order processed successfully!");
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Dependency Inversion Principle Demo ===\n");
        
        // 1. UserService with different databases
        System.out.println("1. UserService with different databases:");
        
        UserService mysqlUserService = new UserService(new MySQLDatabase());
        mysqlUserService.createUser("John Doe");
        System.out.println("Retrieved: " + mysqlUserService.getUser(1));
        
        UserService postgresUserService = new UserService(new PostgreSQLDatabase());
        postgresUserService.createUser("Jane Smith");
        System.out.println("Retrieved: " + postgresUserService.getUser(2));
        
        UserService fileUserService = new UserService(new FileDatabase());
        fileUserService.createUser("Bob Johnson");
        System.out.println("Retrieved: " + fileUserService.getUser(3));
        
        // 2. OrderService with different combinations
        System.out.println("\n2. OrderService with different notification methods:");
        
        OrderService emailOrderService = new OrderService(
            new MySQLDatabase(), 
            new EmailNotification()
        );
        emailOrderService.processOrder("Order #123");
        
        OrderService smsOrderService = new OrderService(
            new PostgreSQLDatabase(), 
            new SMSNotification()
        );
        smsOrderService.processOrder("Order #456");
        
        OrderService pushOrderService = new OrderService(
            new FileDatabase(), 
            new PushNotification()
        );
        pushOrderService.processOrder("Order #789");
        
        System.out.println("\nBenefits of DIP:");
        System.out.println("1. High-level modules don't depend on low-level modules");
        System.out.println("2. Both depend on abstractions (interfaces)");
        System.out.println("3. Easy to swap implementations without changing business logic");
        System.out.println("4. Better testability with mock implementations");
        System.out.println("5. Loose coupling between components");
    }
}
