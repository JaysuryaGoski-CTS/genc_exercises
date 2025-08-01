package com.cafe;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * Espresso Machine Implementation - Singleton Bean
 */
@Component("espressoMachine")
@Scope("singleton")
public class EspressoMachine implements CoffeeMachine {
    
    public EspressoMachine() {
        System.out.println("🔧 EspressoMachine Constructor Called - Singleton Bean Created");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("☕ EspressoMachine @PostConstruct - Bean Initialized");
    }
    
    @Override
    public String makeCoffee() {
        return "Making Espresso ☕";
    }
    
    @Override
    public String getType() {
        return "Espresso Machine";
    }
}
