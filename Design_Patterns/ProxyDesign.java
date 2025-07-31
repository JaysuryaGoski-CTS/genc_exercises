package Design_Patterns;

// Subject interface
interface Image {
    void display();
}

// Real Subject - expensive object to create
class RealImage implements Image {
    private String filename;
    
    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }
    
    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
        // Simulate expensive loading operation
        try {
            Thread.sleep(1000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Image loaded successfully: " + filename);
    }
    
    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy class
class ImageProxy implements Image {
    private String filename;
    private RealImage realImage;
    
    public ImageProxy(String filename) {
        this.filename = filename;
        System.out.println("ImageProxy created for: " + filename);
    }
    
    @Override
    public void display() {
        // Lazy initialization - create real object only when needed
        if (realImage == null) {
            System.out.println("First time display - creating real image...");
            realImage = new RealImage(filename);
        } else {
            System.out.println("Using cached image...");
        }
        realImage.display();
    }
}

// Another example: Protection Proxy for access control
interface Document {
    void viewDocument();
    void editDocument();
}

class RealDocument implements Document {
    private String documentName;
    
    public RealDocument(String documentName) {
        this.documentName = documentName;
    }
    
    @Override
    public void viewDocument() {
        System.out.println("Viewing document: " + documentName);
    }
    
    @Override
    public void editDocument() {
        System.out.println("Editing document: " + documentName);
    }
}

class DocumentProxy implements Document {
    private RealDocument realDocument;
    private String documentName;
    private String userRole;
    
    public DocumentProxy(String documentName, String userRole) {
        this.documentName = documentName;
        this.userRole = userRole;
        this.realDocument = new RealDocument(documentName);
    }
    
    @Override
    public void viewDocument() {
        System.out.println("Access control: Checking view permissions for role: " + userRole);
        realDocument.viewDocument();
    }
    
    @Override
    public void editDocument() {
        System.out.println("Access control: Checking edit permissions for role: " + userRole);
        if ("admin".equalsIgnoreCase(userRole) || "editor".equalsIgnoreCase(userRole)) {
            realDocument.editDocument();
        } else {
            System.out.println("Access DENIED! Role '" + userRole + "' cannot edit documents.");
        }
    }
}

public class ProxyDesign {
    public static void main(String[] args) {
        System.out.println("=== Proxy Design Pattern Demo ===\n");
        
        // 1. Virtual Proxy Example (Lazy Loading)
        System.out.println("1. VIRTUAL PROXY - Lazy Loading Example:");
        System.out.println("-".repeat(45));
        
        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");
        
        System.out.println("\nImages created (but not loaded yet)");
        
        System.out.println("\nFirst display of image1:");
        image1.display();
        
        System.out.println("\nSecond display of image1 (should use cache):");
        image1.display();
        
        System.out.println("\nFirst display of image2:");
        image2.display();
        
        // 2. Protection Proxy Example (Access Control)
        System.out.println("\n\n2. PROTECTION PROXY - Access Control Example:");
        System.out.println("-".repeat(50));
        
        // Admin user
        Document adminDoc = new DocumentProxy("confidential.pdf", "admin");
        System.out.println("\nAdmin user actions:");
        adminDoc.viewDocument();
        adminDoc.editDocument();
        
        // Regular user
        Document userDoc = new DocumentProxy("confidential.pdf", "user");
        System.out.println("\nRegular user actions:");
        userDoc.viewDocument();
        userDoc.editDocument();
        
        // Editor user
        Document editorDoc = new DocumentProxy("confidential.pdf", "editor");
        System.out.println("\nEditor user actions:");
        editorDoc.viewDocument();
        editorDoc.editDocument();
        
        System.out.println("\n=== Proxy Pattern Benefits ===");
        System.out.println("1. Lazy Loading: Objects created only when needed");
        System.out.println("2. Access Control: Security checks before accessing real object");
        System.out.println("3. Caching: Avoid repeated expensive operations");
        System.out.println("4. Logging: Can add logging without changing real object");
    }
}
