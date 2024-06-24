public class FactorialResult {
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialResult calculator = new FactorialResult();
        System.out.println("Factorial of 5: " + calculator.factorial(5));  // Результат = 120
    }
}

