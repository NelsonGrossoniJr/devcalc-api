package com.devcalc.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void testAdd() {
        // Teste básico
        assertEquals(15.0, calculatorService.add(10.0, 5.0));
        assertEquals(0.0, calculatorService.add(0.0, 0.0));
        assertEquals(-5.0, calculatorService.add(-10.0, 5.0));
        assertEquals(2.5, calculatorService.add(1.2, 1.3));
    }

    @Test
    void testSubtract() {
        // Teste básico
        assertEquals(5.0, calculatorService.subtract(10.0, 5.0));
        assertEquals(0.0, calculatorService.subtract(5.0, 5.0));
        assertEquals(-15.0, calculatorService.subtract(-10.0, 5.0));
        assertEquals(-0.1, calculatorService.subtract(1.2, 1.3), 0.0001);
    }

    @Test
    void testMultiply() {
        // Teste básico
        assertEquals(50.0, calculatorService.multiply(10.0, 5.0));
        assertEquals(0.0, calculatorService.multiply(0.0, 5.0));
        assertEquals(-50.0, calculatorService.multiply(-10.0, 5.0));
        assertEquals(1.56, calculatorService.multiply(1.2, 1.3), 0.0001);
    }

    @Test
    void testDivide() {
        // Teste básico
        assertEquals(2.0, calculatorService.divide(10.0, 5.0));
        assertEquals(0.0, calculatorService.divide(0.0, 5.0));
        assertEquals(-2.0, calculatorService.divide(-10.0, 5.0));
        assertEquals(0.923, calculatorService.divide(1.2, 1.3), 0.001);
    }

    @Test
    void testDivideByZero() {
        // Teste de divisão por zero
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculatorService.divide(10.0, 0.0)
        );
        
        assertEquals("Divisão por zero não é permitida", exception.getMessage());
    }

    @Test
    void testDivideByZeroNegative() {
        // Teste de divisão por zero com número negativo
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculatorService.divide(-10.0, 0.0)
        );
        
        assertEquals("Divisão por zero não é permitida", exception.getMessage());
    }

    @Test
    void testEdgeCases() {
        // Teste com números muito pequenos
        assertEquals(0.0, calculatorService.add(0.0, 0.0));
        assertEquals(1.0, calculatorService.divide(1.0, 1.0));
        
        // Teste com números decimais
        assertEquals(3.14159, calculatorService.add(1.14159, 2.0), 0.00001);
    }
}