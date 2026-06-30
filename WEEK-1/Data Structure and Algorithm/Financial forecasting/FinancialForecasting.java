/**
 * Exercise 7: Financial Forecasting
 * 
 * ====================================================================
 * 1. UNDERSTANDING RECURSIVE ALGORITHMS:
 * ====================================================================
 * 
 * Recursion:
 * - Recursion is a technique where a method calls itself to solve
 *   smaller sub-problems until it reaches a base case.
 * - It simplifies problems that have a naturally recursive structure,
 *   such as calculating compound growth, factorials, or Fibonacci numbers.
 * 
 * How recursion simplifies problems:
 * - Breaks down a complex problem into smaller, identical sub-problems.
 * - Each recursive call handles one step of the problem.
 * - The base case stops the recursion and prevents infinite loops.
 * 
 * ====================================================================
 * 2. IMPLEMENTATION: Recursive Financial Forecasting
 * ====================================================================
 * 
 * Formula: FutureValue(n) = PresentValue * (1 + growthRate) ^ n
 * 
 * Recursive approach:
 *   - Base Case: If n == 0, return the present value (no growth).
 *   - Recursive Case: FutureValue(n) = FutureValue(n-1) * (1 + growthRate)
 * 
 * ====================================================================
 * 3. ANALYSIS:
 * ====================================================================
 * 
 * Time Complexity: O(n)
 *   - The method makes exactly n recursive calls before reaching base case.
 * 
 * Space Complexity: O(n)
 *   - Each recursive call adds a frame to the call stack.
 * 
 * Optimization:
 *   - Memoization: Store previously computed values to avoid redundant
 *     calculations (useful when same sub-problems are computed repeatedly).
 *   - Iterative approach: Convert recursion to a loop to reduce stack
 *     overhead and avoid StackOverflowError for large n.
 *   - Tail Recursion: Some languages optimize tail-recursive calls,
 *     though Java does not natively optimize tail recursion.
 * 
 * ====================================================================
 */
public class FinancialForecasting {

    /**
     * Calculates future value using RECURSION.
     * 
     * @param presentValue - The current value of the investment
     * @param growthRate   - The growth rate per period (e.g., 0.05 for 5%)
     * @param periods      - Number of future periods to forecast
     * @return The predicted future value
     * 
     * Time Complexity: O(n) where n = periods
     * Space Complexity: O(n) due to recursive call stack
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base Case: No more periods left
        if (periods == 0) {
            return presentValue;
        }

        // Recursive Case: Apply growth for one period and recurse for remaining
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    /**
     * OPTIMIZED version using an iterative approach.
     * Avoids stack overflow for large number of periods.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - No extra stack frames
     */
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    // ==========================================
    // MAIN METHOD - Test and Compare
    // ==========================================
    public static void main(String[] args) {

        double presentValue = 10000.0; // Initial investment: ₹10,000
        double growthRate = 0.08;       // 8% annual growth rate
        int periods = 10;              // Forecast for 10 years

        System.out.println("========================================");
        System.out.println("    FINANCIAL FORECASTING TOOL");
        System.out.println("========================================");
        System.out.println("Present Value : ₹" + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "% per year");
        System.out.println("Periods       : " + periods + " years");

        // ---- Recursive Approach ----
        System.out.println("\n--- Recursive Approach ---");
        long startTime = System.nanoTime();
        double futureValueRecursive = calculateFutureValue(presentValue, growthRate, periods);
        long endTime = System.nanoTime();
        System.out.printf("Future Value  : ₹%.2f%n", futureValueRecursive);
        System.out.println("Time taken    : " + (endTime - startTime) + " nanoseconds");

        // ---- Iterative (Optimized) Approach ----
        System.out.println("\n--- Iterative (Optimized) Approach ---");
        startTime = System.nanoTime();
        double futureValueIterative = calculateFutureValueIterative(presentValue, growthRate, periods);
        endTime = System.nanoTime();
        System.out.printf("Future Value  : ₹%.2f%n", futureValueIterative);
        System.out.println("Time taken    : " + (endTime - startTime) + " nanoseconds");

        // ---- Year-by-Year Forecast ----
        System.out.println("\n========================================");
        System.out.println("    YEAR-BY-YEAR FORECAST (Recursive)");
        System.out.println("========================================");
        System.out.printf("%-6s | %-15s%n", "Year", "Future Value");
        System.out.println("-------|----------------");
        for (int year = 1; year <= periods; year++) {
            double value = calculateFutureValue(presentValue, growthRate, year);
            System.out.printf("%-6d | ₹%.2f%n", year, value);
        }

        // ---- Analysis ----
        System.out.println("\n========================================");
        System.out.println("          ANALYSIS");
        System.out.println("========================================");
        System.out.println("Recursive Approach:");
        System.out.println("  - Time Complexity : O(n)");
        System.out.println("  - Space Complexity: O(n) (due to call stack)");
        System.out.println("  - Risk: StackOverflowError for very large n");
        System.out.println();
        System.out.println("Iterative Approach (Optimized):");
        System.out.println("  - Time Complexity : O(n)");
        System.out.println("  - Space Complexity: O(1) (constant space)");
        System.out.println("  - No risk of stack overflow");
        System.out.println();
        System.out.println("Optimization Strategies:");
        System.out.println("  1. Memoization - Cache previously computed values.");
        System.out.println("  2. Iteration   - Convert recursion to loop (as shown above).");
        System.out.println("  3. Formula     - Use direct formula: PV * (1 + r)^n");
    }
}
