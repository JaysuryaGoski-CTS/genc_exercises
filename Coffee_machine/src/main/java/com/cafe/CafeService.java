package com.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Cafe Service with Constructor Injection
 */
@Service
public class CafeService {
    
    private final CoffeeMachine coffeeMachine;
    
    // Constructor Injection with @Qualifier
    @Autowired
    public CafeService(@Qualifier("espressoMachine") CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        System.out.println("🏗️ CafeService Constructor - Dependency Injected: " + coffeeMachine.getType());
    }
    
    @PostConstruct
    public void init() {
        System.out.println("🚀 CafeService @PostConstruct - Service Ready!");
    }
    
    @PreDestroy
    public void cleanup() {
        System.out.println("🛑 CafeService @PreDestroy - Service Shutting Down!");
    }
    
    public String makeCoffee() {
        System.out.println("📋 CafeService.makeCoffee() - Processing order...");
        return coffeeMachine.makeCoffee();
    }
    
    public String getMachineType() {
        return coffeeMachine.getType();
    }
}
