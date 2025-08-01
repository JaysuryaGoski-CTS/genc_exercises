package com.cafe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main Application to demonstrate Coffee Machine Simulation
 */
public class CoffeeMachineApp {
    
    public static void main(String[] args) {
        System.out.println("☕ === Coffee Machine Simulation Started ===");
        
        // Create Spring Application Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        System.out.println("\n--- Testing Singleton vs Prototype Beans ---");
        
        // Get CafeService (uses EspressoMachine - Singleton)
        CafeService cafeService1 = context.getBean(CafeService.class);
        CafeService cafeService2 = context.getBean(CafeService.class);
        
        System.out.println("CafeService instances same? " + (cafeService1 == cafeService2));
        
        // Get LatteMachine instances (Prototype)
        LatteMachine latte1 = context.getBean("latteMachine", LatteMachine.class);
        LatteMachine latte2 = context.getBean("latteMachine", LatteMachine.class);
        
        System.out.println("LatteMachine instances same? " + (latte1 == latte2));
        
        System.out.println("\n--- Testing Coffee Making with AOP ---");
        
        // Make coffee (AOP will log this)
        String result = cafeService1.makeCoffee();
        System.out.println("Result: " + result);
        
        // Test with different machines
        System.out.println("\n--- Testing Different Coffee Types ---");
        System.out.println("Latte: " + latte1.makeCoffee());
        
        System.out.println("\n--- Shutting Down ---");
        ((AnnotationConfigApplicationContext) context).close();
        
        System.out.println("☕ === Coffee Machine Simulation Ended ===");
    }
}
