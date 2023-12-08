package com.example.calculatoronlyexception;

public class Calculator {

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) throws DivisionByZeroException {
        if (num2 == 0) {
            throw new DivisionByZeroException();
        } else {
            return num1 / num2;
        }
    }

    public double squareRoot(double num) {
        if (num < 0) {
            // Assuming square root of a negative number is not supported
            throw new IllegalArgumentException("Square root of a negative number is not supported.");
        }
        return Math.sqrt(num);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }


}
