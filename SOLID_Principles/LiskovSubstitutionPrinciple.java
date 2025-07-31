package SOLID_Principles;

// BAD EXAMPLE - Violates LSP
class BadBird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class BadEagle extends BadBird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky");
    }
}

// This violates LSP - Penguin can't fly but inherits fly method
class BadPenguin extends BadBird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly!");
    }
}

// GOOD EXAMPLE - Follows LSP

// Base class with common behavior
abstract class Bird {
    protected String name;
    
    public Bird(String name) {
        this.name = name;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    public abstract void move();
}

// Interface for flying behavior
interface Flyable {
    void fly();
}

// Interface for swimming behavior
interface Swimmable {
    void swim();
}

// Flying birds implement Flyable
class Eagle extends Bird implements Flyable {
    public Eagle() {
        super("Eagle");
    }
    
    @Override
    public void move() {
        fly();
    }
    
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky");
    }
}

class Sparrow extends Bird implements Flyable {
    public Sparrow() {
        super("Sparrow");
    }
    
    @Override
    public void move() {
        fly();
    }
    
    @Override
    public void fly() {
        System.out.println("Sparrow flies quickly");
    }
}

// Non-flying birds don't implement Flyable
class Penguin extends Bird implements Swimmable {
    public Penguin() {
        super("Penguin");
    }
    
    @Override
    public void move() {
        swim();
    }
    
    @Override
    public void swim() {
        System.out.println("Penguin swims gracefully");
    }
}

// Client code that works with substitutable objects
class BirdWatcher {
    public void observeBird(Bird bird) {
        System.out.println("Observing: " + bird.name);
        bird.eat();
        bird.move(); // This works for all birds without breaking
    }
    
    public void watchFlyingBirds(Flyable bird) {
        System.out.println("Watching flying behavior:");
        bird.fly();
    }
    
    public void watchSwimmingBirds(Swimmable bird) {
        System.out.println("Watching swimming behavior:");
        bird.swim();
    }
}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Liskov Substitution Principle Demo ===\n");
        
        BirdWatcher watcher = new BirdWatcher();
        
        // All birds can be substituted for Bird base class
        Bird eagle = new Eagle();
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();
        
        System.out.println("1. General bird behavior (LSP compliant):");
        watcher.observeBird(eagle);
        watcher.observeBird(sparrow);
        watcher.observeBird(penguin);
        
        System.out.println("\n2. Specific flying behavior:");
        watcher.watchFlyingBirds((Flyable) eagle);
        watcher.watchFlyingBirds((Flyable) sparrow);
        // penguin doesn't implement Flyable, so no casting issue
        
        System.out.println("\n3. Specific swimming behavior:");
        watcher.watchSwimmingBirds((Swimmable) penguin);
        
        System.out.println("\nBenefits of LSP:");
        System.out.println("1. Subtypes are substitutable for their base types");
        System.out.println("2. No unexpected behavior when using inheritance");
        System.out.println("3. Maintains contract established by base class");
        System.out.println("4. Enables polymorphism without surprises");
    }
}
