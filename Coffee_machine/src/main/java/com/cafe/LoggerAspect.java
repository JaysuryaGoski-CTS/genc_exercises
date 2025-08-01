package com.cafe;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

/**
 * Logger Aspect for AOP
 */
@Aspect
@Component
public class LoggerAspect {
    
    @Before("execution(* com.cafe.CafeService.makeCoffee(..))")
    public void logBefore() {
        System.out.println("🔍 [AOP @Before] Starting coffee preparation...");
    }
    
    @After("execution(* com.cafe.CafeService.makeCoffee(..))")
    public void logAfter() {
        System.out.println("✅ [AOP @After] Coffee preparation completed!");
    }
}
