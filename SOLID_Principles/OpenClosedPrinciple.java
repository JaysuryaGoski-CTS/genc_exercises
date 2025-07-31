package SOLID_Principles;

// BAD EXAMPLE - Violates OCP (Need to modify existing code for new shapes)
class BadAreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof BadRectangle) {
            BadRectangle rect = (BadRectangle) shape;
            return rect.width * rect.height;
        } else if (shape instanceof BadCircle) {
            BadCircle circle = (BadCircle) shape;
            return Math.PI * circle.radius * circle.radius;
        }
        // To add new shape, we need to modify this method (violates OCP)
        return 0;
    }
}

class BadRectangle {
    public double width, height;
    public BadRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class BadCircle {
    public double radius;
    public BadCircle(double radius) {
        this.radius = radius;
    }
}

// GOOD EXAMPLE - Follows OCP (Open for extension, closed for modification)

// Abstract base class/interface
abstract class Shape {
    public abstract double calculateArea();
    public abstract String getName();
}

// Existing implementations
class Rectangle extends Shape {
    private double width, height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public String getName() {
        return "Rectangle";
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public String getName() {
        return "Circle";
    }
}

// NEW shape can be added without modifying existing code
class Triangle extends Shape {
    private double base, height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    @Override
    public String getName() {
        return "Triangle";
    }
}

// Calculator class doesn't need modification for new shapes
class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
    
    public void printAreaInfo(Shape shape) {
        System.out.println(shape.getName() + " area: " + calculateArea(shape));
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Open-Closed Principle Demo ===\n");
        
        AreaCalculator calculator = new AreaCalculator();
        
        // Original shapes
        Shape rectangle = new Rectangle(5, 4);
        Shape circle = new Circle(3);
        
        // New shape added without modifying existing code
        Shape triangle = new Triangle(6, 8);
        
        System.out.println("Calculating areas:");
        calculator.printAreaInfo(rectangle);
        calculator.printAreaInfo(circle);
        calculator.printAreaInfo(triangle);
        
        System.out.println("\nBenefits of OCP:");
        System.out.println("1. Can add new functionality without changing existing code");
        System.out.println("2. Reduces risk of breaking existing functionality");
        System.out.println("3. Makes code more maintainable and extensible");
        System.out.println("4. Follows the principle: Open for extension, Closed for modification");
    }
}
