public class FibonacciComparison {
    // Recursive Fibonacci (O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int n = 30; // Change N to test different values

        // Test Recursive Fibonacci
        System.out.println("Computing Fibonacci(" + n + ") using Recursion...");
        long startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long recursiveTime = System.nanoTime() - startTime;
        System.out.println("Recursive Result: " + recursiveResult);
        System.out.println("Recursive Time: " + (recursiveTime / 1_000_000.0) + " ms\n");

        // Test Iterative Fibonacci
        System.out.println("Computing Fibonacci(" + n + ") using Iteration...");
        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        long iterativeTime = System.nanoTime() - startTime;
        System.out.println("Iterative Result: " + iterativeResult);
        System.out.println("Iterative Time: " + (iterativeTime / 1_000_000.0) + " ms");
    }
}
