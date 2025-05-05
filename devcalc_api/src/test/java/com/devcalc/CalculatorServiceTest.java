package com.devcalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    CalculatorService calc = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(7, calc.add(3, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calc.subtract(5, 4));
    }

    @Test
    void testMultiply() {
        assertEquals(12, calc.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide(10, 5));
    }
}
