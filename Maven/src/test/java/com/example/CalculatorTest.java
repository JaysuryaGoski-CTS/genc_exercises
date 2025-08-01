package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Calculator class
 */
public class CalculatorTest {
    
    private Calculator calculator = new Calculator();
    
    @Test
    public void testAdd() {
        assertEquals(8, calculator.add(5, 3));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-8, calculator.add(-3, -5));
    }
    
    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(2, calculator.subtract(-3, -5));
    }
    
    @Test
    public void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(-25, calculator.multiply(-5, 5));
        assertEquals(15, calculator.multiply(-3, -5));
        assertEquals(0, calculator.multiply(0, 5));
    }
}
