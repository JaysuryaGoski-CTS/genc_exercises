package com.cafe;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Latte Machine Implementation - Prototype Bean
 */
@Component("latteMachine")
@Scope("prototype")
public class LatteMachine implements CoffeeMachine {
    
    public LatteMachine() {
        System.out.println("🔧 LatteMachine Constructor Called - Prototype Bean Created");
    }
    
    @Override
    public String makeCoffee() {
        return "Making Latte ☕🥛";
    }
    
    @Override
    public String getType() {
        return "Latte Machine";
    }
}
