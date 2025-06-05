package com.devcalc;

public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {return a - b;}

    public int multiply(int a, int b) {return a * b;}

    public int divide(int a, int b) {return a / b;}

    public double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Erro - Não é possível calcular a raiz quadrada de número negativo!");
        }
        return Math.sqrt(x);
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Erro - Não é possível divir por zero!");
        }
        return a / b;
    }
}
