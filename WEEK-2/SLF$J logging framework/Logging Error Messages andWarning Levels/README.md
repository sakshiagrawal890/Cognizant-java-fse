# Exercise 1: Logging Error Messages and Warning Levels

This project demonstrates logging error messages and warning levels using the **SLF4J** API and the **Logback** implementation.

---

## 📁 Project Structure

```
Logging Error Messages andWarning Levels/
├── pom.xml                     # Maven project configuration
├── lib/                        # Downloaded JAR dependencies (SLF4J, Logback)
└── src/
    └── main/
        └── java/
            └── LoggingExample.java  # Logging implementation using SLF4J
```

---

## 🛠️ Code Implementation

### **LoggingExample.java**
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
```

---

## ▶️ How to Run

Since `mvn` (Maven CLI) may not be configured in your environment's path, we have pre-downloaded the required JAR dependencies into the `lib` folder so you can compile and run this program directly using standard Java command line commands.

### **Step 1: Open Terminal and navigate to the project directory**
```powershell
cd "c:\Users\SHAKSHI\OneDrive\Desktop\Cognizant-java-fse\WEEK-2\SLF$J logging framework\Logging Error Messages andWarning Levels"
```

### **Step 2: Compile the Java Class**
We include the JAR files in the classpath (`-cp`) during compilation:
```powershell
javac -cp "lib/*" src/main/java/LoggingExample.java
```

### **Step 3: Run the Application**
Run the compiled class by linking the libraries and the source folder:
```powershell
java -cp "lib/*;src/main/java" LoggingExample
```

---

## ✅ Expected Output
```
10:11:03.450 [main] ERROR LoggingExample - This is an error message
10:11:03.455 [main] WARN LoggingExample - This is a warning message
```
