# TDD using JUnit5 and Mockito

This module contains practical implementations of unit testing concepts using **JUnit**.

---

## 📁 Module Structure

```
TDD using JUnit5 and Mockito/
├── Setting up JUnit/                 # Exercise 1: JUnit Configuration
│   ├── pom.xml
│   ├── lib/                         # JUnit libraries
│   └── src/test/java/
│       └── JUnitSetupTest.java      # Basic setup test
│
├── Assertions in Junit/              # Exercise 3: Various Assertions
│   ├── pom.xml
│   ├── lib/                         # JUnit libraries
│   └── src/test/java/
│       └── AssertionsTest.java      # Test asserting equals, true, null, etc.
│
└── AAA pattern/                      # Exercise 4: AAA Pattern & Fixtures
    ├── pom.xml
    ├── lib/                         # JUnit libraries
    ├── src/main/java/
    │   └── Calculator.java          # Calculator class
    └── src/test/java/
        └── CalculatorTest.java      # Test using @Before, @After and AAA
```

---

## ▶️ How to Run the Tests

Since Maven is not set up globally in the PATH environment, we have bundled the necessary dependencies (`junit-4.13.2.jar` & `hamcrest-core-1.3.jar`) inside the `lib` folder of each project.

### **1. Running "Setting up JUnit" (Exercise 1)**
```powershell
cd "c:\Users\SHAKSHI\OneDrive\Desktop\Cognizant-java-fse\WEEK-2\TDD using JUnit5 and Mockito\Setting up JUnit"
javac -cp "lib/*" src/test/java/JUnitSetupTest.java
java -cp "lib/*;src/test/java" org.junit.runner.JUnitCore JUnitSetupTest
```

### **2. Running "Assertions in Junit" (Exercise 3)**
```powershell
cd "c:\Users\SHAKSHI\OneDrive\Desktop\Cognizant-java-fse\WEEK-2\TDD using JUnit5 and Mockito\Assertions in Junit"
javac -cp "lib/*" src/test/java/AssertionsTest.java
java -cp "lib/*;src/test/java" org.junit.runner.JUnitCore AssertionsTest
```

### **3. Running "AAA pattern" (Exercise 4)**
```powershell
cd "c:\Users\SHAKSHI\OneDrive\Desktop\Cognizant-java-fse\WEEK-2\TDD using JUnit5 and Mockito\AAA pattern"
mkdir bin 2>$null
javac -d bin -cp "lib/*" src/main/java/Calculator.java src/test/java/CalculatorTest.java
java -cp "lib/*;bin" org.junit.runner.JUnitCore CalculatorTest
```
*(On Git Bash / Linux, if the `;` in `-cp` throws an error, use `:` separator or run it in standard Windows Command Prompt/PowerShell)*
