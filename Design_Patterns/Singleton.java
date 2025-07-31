package Design_Patterns;

public class Singleton {
    // Private static instance of the class (initially null)
    private static Singleton instance = null;
    
    // Private constructor to prevent instantiation from outside
    private Singleton() {
        System.out.println("Singleton instance created!");
    }
    
    // Public static method to get the single instance
    public static Singleton getInstance() {
        // Create instance only if it doesn't exist (lazy initialization)
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from Singleton! Hash code: " + this.hashCode());
    }
    
    // Main method to test the Singleton pattern
    public static void main(String[] args) {
        System.out.println("=== Singleton Design Pattern Demo ===");
        
        // Get first instance
        Singleton obj1 = Singleton.getInstance();
        obj1.showMessage();
        
        // Get second instance
        Singleton obj2 = Singleton.getInstance();
        obj2.showMessage();
        
        // Check if both references point to the same object
        System.out.println("Are both objects the same? " + (obj1 == obj2));
        System.out.println("obj1 hash code: " + obj1.hashCode());
        System.out.println("obj2 hash code: " + obj2.hashCode());
    }
}
