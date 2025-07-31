package SOLID_Principles;

// BAD EXAMPLE - Violates ISP (Fat interface forces unnecessary implementations)
interface BadWorker {
    void work();
    void eat();
    void sleep();
    void attendMeeting();
    void writeCode();
    void designUI();
    void testSoftware();
}

// All workers must implement all methods, even if not relevant
class BadDeveloper implements BadWorker {
    @Override
    public void work() { System.out.println("Developer is working"); }
    
    @Override
    public void eat() { System.out.println("Developer is eating"); }
    
    @Override
    public void sleep() { System.out.println("Developer is sleeping"); }
    
    @Override
    public void attendMeeting() { System.out.println("Developer attending meeting"); }
    
    @Override
    public void writeCode() { System.out.println("Developer writing code"); }
    
    @Override
    public void designUI() { 
        // Developer might not do UI design
        throw new UnsupportedOperationException("Not my job!");
    }
    
    @Override
    public void testSoftware() { System.out.println("Developer testing code"); }
}

// GOOD EXAMPLE - Follows ISP (Segregated interfaces)

// Basic worker interface
interface Worker {
    void work();
}

// Basic human needs
interface Eater {
    void eat();
}

interface Sleeper {
    void sleep();
}

// Professional activities
interface MeetingAttendee {
    void attendMeeting();
}

interface Programmer {
    void writeCode();
    void debug();
}

interface Designer {
    void designUI();
    void createMockups();
}

interface Tester {
    void testSoftware();
    void reportBugs();
}

// Now classes implement only relevant interfaces
class Developer implements Worker, Eater, Sleeper, MeetingAttendee, Programmer, Tester {
    private String name;
    
    public Developer(String name) {
        this.name = name;
    }
    
    @Override
    public void work() { System.out.println(name + " is working on development tasks"); }
    
    @Override
    public void eat() { System.out.println(name + " is eating lunch"); }
    
    @Override
    public void sleep() { System.out.println(name + " is sleeping"); }
    
    @Override
    public void attendMeeting() { System.out.println(name + " is attending standup meeting"); }
    
    @Override
    public void writeCode() { System.out.println(name + " is writing clean code"); }
    
    @Override
    public void debug() { System.out.println(name + " is debugging issues"); }
    
    @Override
    public void testSoftware() { System.out.println(name + " is unit testing"); }
    
    @Override
    public void reportBugs() { System.out.println(name + " is reporting bugs found"); }
}

class UIDesigner implements Worker, Eater, Sleeper, MeetingAttendee, Designer {
    private String name;
    
    public UIDesigner(String name) {
        this.name = name;
    }
    
    @Override
    public void work() { System.out.println(name + " is working on design tasks"); }
    
    @Override
    public void eat() { System.out.println(name + " is eating lunch"); }
    
    @Override
    public void sleep() { System.out.println(name + " is sleeping"); }
    
    @Override
    public void attendMeeting() { System.out.println(name + " is attending design review"); }
    
    @Override
    public void designUI() { System.out.println(name + " is creating beautiful UI designs"); }
    
    @Override
    public void createMockups() { System.out.println(name + " is creating interactive mockups"); }
}

class QATester implements Worker, Eater, Sleeper, MeetingAttendee, Tester {
    private String name;
    
    public QATester(String name) {
        this.name = name;
    }
    
    @Override
    public void work() { System.out.println(name + " is working on testing tasks"); }
    
    @Override
    public void eat() { System.out.println(name + " is eating lunch"); }
    
    @Override
    public void sleep() { System.out.println(name + " is sleeping"); }
    
    @Override
    public void attendMeeting() { System.out.println(name + " is attending QA meeting"); }
    
    @Override
    public void testSoftware() { System.out.println(name + " is performing comprehensive testing"); }
    
    @Override
    public void reportBugs() { System.out.println(name + " is filing detailed bug reports"); }
}

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Interface Segregation Principle Demo ===\n");
        
        Developer dev = new Developer("Alice");
        UIDesigner designer = new UIDesigner("Bob");
        QATester tester = new QATester("Carol");
        
        System.out.println("1. Developer activities:");
        dev.work();
        dev.writeCode();
        dev.debug();
        dev.testSoftware();
        dev.attendMeeting();
        
        System.out.println("\n2. UI Designer activities:");
        designer.work();
        designer.designUI();
        designer.createMockups();
        designer.attendMeeting();
        
        System.out.println("\n3. QA Tester activities:");
        tester.work();
        tester.testSoftware();
        tester.reportBugs();
        tester.attendMeeting();
        
        System.out.println("\nBenefits of ISP:");
        System.out.println("1. Classes implement only methods they actually use");
        System.out.println("2. No forced implementation of irrelevant methods");
        System.out.println("3. More focused and cohesive interfaces");
        System.out.println("4. Easier to maintain and extend");
        System.out.println("5. Reduces coupling between classes");
    }
}
