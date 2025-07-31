package Design_Patterns;

// Product interface
interface Animal {
    void makeSound();
    void getInfo();
}

// Concrete Products
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
    
    @Override
    public void getInfo() {
        System.out.println("I am a Dog - loyal and friendly!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
    
    @Override
    public void getInfo() {
        System.out.println("I am a Cat - independent and curious!");
    }
}

class Bird implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }
    
    @Override
    public void getInfo() {
        System.out.println("I am a Bird - I can fly high!");
    }
}

// Factory class
class AnimalFactory {
    // Factory method to create animals
    public static Animal createAnimal(String animalType) {
        if (animalType == null || animalType.isEmpty()) {
            return null;
        }
        
        switch (animalType.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "bird":
                return new Bird();
            default:
                System.out.println("Unknown animal type: " + animalType);
                return null;
        }
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Design Pattern Demo ===\n");
        
        // Create different animals using the factory
        String[] animalTypes = {"dog", "cat", "bird", "elephant"};
        
        for (String type : animalTypes) {
            System.out.println("Creating: " + type.toUpperCase());
            
            // Use factory to create animal
            Animal animal = AnimalFactory.createAnimal(type);
            
            if (animal != null) {
                animal.getInfo();
                animal.makeSound();
            }
            System.out.println("-".repeat(30));
        }
        
        // Demonstrate the benefit: client doesn't need to know concrete classes
        System.out.println("\n=== Creating animals without knowing concrete classes ===");
        createAndUseAnimal("dog");
        createAndUseAnimal("cat");
    }
    
    // Method that uses factory - doesn't need to know about concrete classes
    private static void createAndUseAnimal(String type) {
        Animal animal = AnimalFactory.createAnimal(type);
        if (animal != null) {
            System.out.print("Created " + type + ": ");
            animal.makeSound();
        }
    }
}
