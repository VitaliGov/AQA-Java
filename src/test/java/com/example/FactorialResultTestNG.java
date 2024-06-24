package com.example;

import org.testng.annotations.Test;
import java.math.BigInteger;
import static org.testng.Assert.*;

public class FactorialResultTestNG {

    @Test
    public void testFactorial() {
        FactorialResult calculator = new FactorialResult();
        assertEquals(calculator.factorial(0), BigInteger.ONE);
        assertEquals(calculator.factorial(1), BigInteger.ONE);
        assertEquals(calculator.factorial(2), BigInteger.valueOf(2));
        assertEquals(calculator.factorial(3), BigInteger.valueOf(6));
        assertEquals(calculator.factorial(4), BigInteger.valueOf(24));
        assertEquals(calculator.factorial(5), BigInteger.valueOf(120));
        //assertEquals(calculator.factorial(-5), BigInteger.valueOf(120));
        //  ошибка
        //assertEquals(calculator.factorial(5), BigInteger.valueOf(10)); // Должно быть 120, но указано 10
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialWithNegativeNumber() {
        FactorialResult calculator = new FactorialResult();
        calculator.factorial(-1);
    }
}
