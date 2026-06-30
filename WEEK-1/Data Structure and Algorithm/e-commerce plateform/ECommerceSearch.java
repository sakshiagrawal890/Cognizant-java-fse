import java.util.Arrays;
import java.util.Comparator;

/**
 * Exercise 2: E-commerce Platform Search Function
 * 
 * ====================================================================
 * 1. UNDERSTANDING ASYMPTOTIC NOTATION (Big O):
 * ====================================================================
 * 
 * Big O Notation:
 * - Big O notation describes the upper bound of an algorithm's time complexity.
 * - It tells us how the runtime grows as the input size (n) increases.
 * - It helps compare algorithms and choose the most efficient one.
 * 
 * Common Big O complexities:
 *   O(1)       - Constant time (e.g., accessing an array element by index)
 *   O(log n)   - Logarithmic time (e.g., Binary Search)
 *   O(n)       - Linear time (e.g., Linear Search)
 *   O(n log n) - Linearithmic time (e.g., Merge Sort)
 *   O(n^2)     - Quadratic time (e.g., Bubble Sort)
 * 
 * Search Operation Scenarios:
 * -------------------------------------------------------------------
 * | Algorithm     | Best Case | Average Case | Worst Case |
 * |---------------|-----------|--------------|------------|
 * | Linear Search | O(1)      | O(n)         | O(n)       |
 * | Binary Search | O(1)      | O(log n)     | O(log n)   |
 * -------------------------------------------------------------------
 * 
 * Linear Search:
 *   - Best Case O(1): Element is found at the first position.
 *   - Average Case O(n): Element is somewhere in the middle.
 *   - Worst Case O(n): Element is at the last position or not present.
 * 
 * Binary Search:
 *   - Best Case O(1): Element is at the middle of the array.
 *   - Average Case O(log n): Element is found after several divisions.
 *   - Worst Case O(log n): Element is at the extreme end or not present.
 *   - Requirement: The array MUST be sorted.
 * 
 * ====================================================================
 * 2. IMPLEMENTATION: Linear Search and Binary Search
 * ====================================================================
 */
public class ECommerceSearch {

    // ==========================================
    // LINEAR SEARCH - Searches by productName
    // Time Complexity: O(n)
    // ==========================================
    public static Product linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return products[i];
            }
        }
        return null; // Product not found
    }

    // ==========================================
    // BINARY SEARCH - Searches by productName
    // Time Complexity: O(log n)
    // Requires: Array must be sorted by productName
    // ==========================================
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid]; // Product found
            } else if (comparison < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return null; // Product not found
    }

    // ==========================================
    // MAIN METHOD - Test and Compare
    // ==========================================
    public static void main(String[] args) {

        // Create an array of products
        Product[] products = {
            new Product(101, "Laptop",      "Electronics"),
            new Product(102, "Smartphone",  "Electronics"),
            new Product(103, "Headphones",  "Accessories"),
            new Product(104, "Tablet",      "Electronics"),
            new Product(105, "Keyboard",    "Accessories"),
            new Product(106, "Mouse",       "Accessories"),
            new Product(107, "Monitor",     "Electronics"),
            new Product(108, "Charger",     "Accessories"),
            new Product(109, "Camera",      "Electronics"),
            new Product(110, "Printer",     "Electronics")
        };

        String searchTarget = "Tablet";

        // ---- LINEAR SEARCH ----
        System.out.println("========================================");
        System.out.println("       LINEAR SEARCH");
        System.out.println("========================================");

        long startTime = System.nanoTime();
        Product result1 = linearSearch(products, searchTarget);
        long endTime = System.nanoTime();

        if (result1 != null) {
            System.out.println("Found: " + result1);
        } else {
            System.out.println("Product '" + searchTarget + "' not found.");
        }
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");

        // ---- BINARY SEARCH ----
        System.out.println("\n========================================");
        System.out.println("       BINARY SEARCH");
        System.out.println("========================================");

        // Sort the array by productName for binary search
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Sorted Products:");
        for (Product p : sortedProducts) {
            System.out.println("  " + p);
        }
        System.out.println();

        startTime = System.nanoTime();
        Product result2 = binarySearch(sortedProducts, searchTarget);
        endTime = System.nanoTime();

        if (result2 != null) {
            System.out.println("Found: " + result2);
        } else {
            System.out.println("Product '" + searchTarget + "' not found.");
        }
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");

        // ---- ANALYSIS ----
        System.out.println("\n========================================");
        System.out.println("       ANALYSIS & COMPARISON");
        System.out.println("========================================");
        System.out.println("| Algorithm     | Time Complexity |");
        System.out.println("|---------------|-----------------|");
        System.out.println("| Linear Search | O(n)            |");
        System.out.println("| Binary Search | O(log n)        |");
        System.out.println();
        System.out.println("Conclusion:");
        System.out.println("- For a small dataset, Linear Search is simple and effective.");
        System.out.println("- For a large e-commerce platform with thousands of products,");
        System.out.println("  Binary Search is far more suitable because of O(log n) complexity.");
        System.out.println("- Binary Search requires the data to be sorted, which adds a");
        System.out.println("  one-time cost of O(n log n), but subsequent searches are much faster.");
        System.out.println("- Recommendation: Use Binary Search for the e-commerce platform.");
    }
}
