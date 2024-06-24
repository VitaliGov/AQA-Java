import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialResultTestJUnit5 {

    @Test
    void testFactorial() {
        FactorialResult calculator = new FactorialResult();
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(24, calculator.factorial(4));
        assertEquals(120, calculator.factorial(5));
        //assertEquals(120, calculator.factorial(-5));
        // ошибка
        //assertEquals(10, calculator.factorial(5));
    }

    @Test
    void testFactorialWithNegativeNumber() {
        FactorialResult calculator = new FactorialResult();
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }
}
