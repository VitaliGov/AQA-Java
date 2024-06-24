package com.example;

import java.math.BigInteger;

public class FactorialResult {
    public BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialResult calculator = new FactorialResult();
        System.out.println("Factorial of 5: " + calculator.factorial(5));  // Output: 120
    }
}
