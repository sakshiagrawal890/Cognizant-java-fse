# Data Structure and Algorithm

This module covers important **Data Structures and Algorithms** in Java, focusing on search optimization and recursive problem-solving.

---

## 📁 Folder Structure

```
Data Structure and Algorithm/
├── e-commerce plateform/
│   ├── Product.java            # Product class with search attributes
│   └── ECommerceSearch.java    # Linear Search & Binary Search implementation
│
└── Financial forecasting/
    └── FinancialForecasting.java  # Recursive & Iterative forecasting
```

---

## Exercise 2: E-commerce Platform Search Function

### 📌 Scenario
Optimize the **search functionality** of an e-commerce platform for fast performance using Linear Search and Binary Search.

### 🔑 Key Concepts

#### Big O Notation
Big O notation describes the **upper bound** of an algorithm's time complexity — how the runtime grows as input size (n) increases.

| Notation | Name | Example |
|----------|------|---------|
| O(1) | Constant | Array access by index |
| O(log n) | Logarithmic | Binary Search |
| O(n) | Linear | Linear Search |
| O(n log n) | Linearithmic | Merge Sort |
| O(n²) | Quadratic | Bubble Sort |

#### Search Algorithms Comparison

| Algorithm | Best Case | Average Case | Worst Case | Requires Sorting? |
|-----------|-----------|--------------|------------|-------------------|
| **Linear Search** | O(1) | O(n) | O(n) | ❌ No |
| **Binary Search** | O(1) | O(log n) | O(log n) | ✅ Yes |

### 🏗️ How It Works
- **Linear Search**: Scans each element one by one from start to end.
- **Binary Search**: Divides the sorted array in half each time, eliminating half the search space.

### ▶️ How to Run
```bash
cd "WEEK-1/Data Structure and Algorithm/e-commerce plateform"
javac Product.java ECommerceSearch.java
java ECommerceSearch
```

### ✅ Expected Output
```
========================================
       LINEAR SEARCH
========================================
Found: Product{productId=104, productName='Tablet', category='Electronics'}
Time taken: 83100 nanoseconds

========================================
       BINARY SEARCH
========================================
Sorted Products:
  Product{productId=109, productName='Camera', category='Electronics'}
  ...
Found: Product{productId=104, productName='Tablet', category='Electronics'}
Time taken: 33700 nanoseconds

========================================
       ANALYSIS & COMPARISON
========================================
Conclusion:
- Binary Search is more suitable for large e-commerce platforms.
- Binary Search requires sorted data (one-time cost of O(n log n)).
- Recommendation: Use Binary Search for the e-commerce platform.
```

---

## Exercise 7: Financial Forecasting

### 📌 Scenario
Develop a **financial forecasting tool** that predicts future values based on past growth rates using recursion.

### 🔑 Key Concepts

#### Recursion
- A technique where a **method calls itself** to solve smaller sub-problems.
- Requires a **base case** to stop the recursion.
- Simplifies problems with naturally recursive structures (e.g., compound growth, factorials).

#### Formula
```
FutureValue(n) = PresentValue × (1 + growthRate) ^ n

Recursive:
  Base Case    → if n == 0, return presentValue
  Recursive    → FutureValue(n) = FutureValue(n-1) × (1 + growthRate)
```

### 📊 Time Complexity Analysis

| Approach | Time Complexity | Space Complexity | Stack Overflow Risk |
|----------|----------------|------------------|---------------------|
| **Recursive** | O(n) | O(n) | ⚠️ Yes, for large n |
| **Iterative (Optimized)** | O(n) | O(1) | ✅ No |

### 🔧 Optimization Strategies
1. **Memoization** — Cache previously computed values to avoid redundant calculations.
2. **Iteration** — Convert recursion to a loop to reduce stack overhead.
3. **Direct Formula** — Use `PV × (1 + r)^n` with `Math.pow()`.

### ▶️ How to Run
```bash
cd "WEEK-1/Data Structure and Algorithm/Financial forecasting"
javac FinancialForecasting.java
java FinancialForecasting
```

### ✅ Expected Output
```
========================================
    FINANCIAL FORECASTING TOOL
========================================
Present Value : ₹10000.0
Growth Rate   : 8.0% per year
Periods       : 10 years

--- Recursive Approach ---
Future Value  : ₹21589.25

--- Iterative (Optimized) Approach ---
Future Value  : ₹21589.25

========================================
    YEAR-BY-YEAR FORECAST (Recursive)
========================================
Year   | Future Value
-------|----------------
1      | ₹10800.00
2      | ₹11664.00
3      | ₹12597.12
...
10     | ₹21589.25
```

---

## 📚 Algorithms Summary

| Exercise | Algorithm | Time Complexity | Use Case |
|----------|-----------|----------------|----------|
| Exercise 2 | Linear Search | O(n) | Small, unsorted datasets |
| Exercise 2 | Binary Search | O(log n) | Large, sorted datasets |
| Exercise 7 | Recursive Forecasting | O(n) | Predicting future values |
| Exercise 7 | Iterative Forecasting | O(n) | Optimized prediction |

---

## 🛠️ Prerequisites
- Java JDK 8 or above
- Any IDE (VS Code, IntelliJ, Eclipse) or terminal
