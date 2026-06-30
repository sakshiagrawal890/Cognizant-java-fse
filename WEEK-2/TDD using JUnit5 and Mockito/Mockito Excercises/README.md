# Mockito Hands-On Exercises

This repository contains hands-on implementations for testing services with dependencies using **Mockito** and **JUnit 5 (Jupiter)**.

---

## 📁 Exercises Structure

```
Mockito Excercises/
├── Mocking and Stubbing/          # Exercise 1: Mocking and Stubbing dependencies
│   ├── pom.xml
│   ├── lib/                       # Bundled Mockito & JUnit 5 JARs
│   ├── src/main/java/
│   │   ├── ExternalApi.java       # Interface to mock
│   │   └── MyService.java         # Service under test
│   └── src/test/java/
│       └── MyServiceTest.java     # Stubbing tests using when().thenReturn()
│
└── Verfiying Interactions/        # Exercise 2: Verifying method interactions
    ├── pom.xml
    ├── lib/                       # Bundled Mockito & JUnit 5 JARs
    ├── src/main/java/
    │   ├── ExternalApi.java       # Interface to mock
    │   └── MyService.java         # Service under test
    └── src/test/java/
        └── MyServiceTest.java     # Verifying method call using verify()
```

---

## ▶️ How to Run the Tests (CLI)

Since Maven dependencies can be complex to run manually on some CLI environments, we have pre-packaged all necessary JAR files inside the `lib` folder of each exercise.

### **1. Running Exercise 1: Mocking and Stubbing**

```powershell
# Navigate to Exercise 1 folder
cd 'C:\Users\SHAKSHI\OneDrive\Desktop\Cognizant-java-fse\WEEK-2\TDD using JUnit5 and Mockito\Mockito Excercises\Mocking and Stubbing'

# Create output folder and compile
mkdir bin 2>$null
javac -d bin -cp "lib/*" src/main/java/*.java src/test/java/*.java

# Run tests using JUnit 5 Console Standalone Launcher
java -jar lib/junit-platform-console-standalone-1.8.2.jar --class-path "bin;lib/mockito-core-4.5.1.jar;lib/byte-buddy-1.12.9.jar;lib/byte-buddy-agent-1.12.9.jar;lib/objenesis-3.2.jar" --select-class MyServiceTest
```

### **2. Running Exercise 2: Verifying Interactions**

```powershell
# Navigate to Exercise 2 folder
cd 'C:\Users\SHAKSHI\OneDrive\Desktop\Cognizant-java-fse\WEEK-2\TDD using JUnit5 and Mockito\Mockito Excercises\Verfiying Interactions'

# Create output folder and compile
mkdir bin 2>$null
javac -d bin -cp "lib/*" src/main/java/*.java src/test/java/*.java

# Run tests using JUnit 5 Console Standalone Launcher
java -jar lib/junit-platform-console-standalone-1.8.2.jar --class-path "bin;lib/mockito-core-4.5.1.jar;lib/byte-buddy-1.12.9.jar;lib/byte-buddy-agent-1.12.9.jar;lib/objenesis-3.2.jar" --select-class MyServiceTest
```

*(Note: On Linux/Git Bash, if the classpath separator `;` throws an error, use `:` instead).*
