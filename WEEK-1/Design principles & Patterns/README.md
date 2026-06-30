# Design Principles & Patterns

This module covers important **Design Patterns** in Java, demonstrating how to write clean, maintainable, and scalable code.

---

## 📁 Folder Structure

```
Design principles & Patterns/
├── Singleton_plateform/
│   ├── Logger.java                 # Singleton Logger class
│   └── SingletonPatternTest.java   # Test class for Singleton
│
└── Factory Method Pattern/
    ├── Document.java               # Document interface
    ├── WordDocument.java           # Concrete Word document
    ├── PdfDocument.java            # Concrete PDF document
    ├── ExcelDocument.java          # Concrete Excel document
    ├── DocumentFactory.java        # Abstract factory class
    ├── WordDocumentFactory.java    # Factory for Word documents
    ├── PdfDocumentFactory.java     # Factory for PDF documents
    ├── ExcelDocumentFactory.java   # Factory for Excel documents
    └── FactoryMethodPatternTest.java  # Test class for Factory Method
```

---

## Exercise 1: Singleton Pattern

### 📌 Scenario
Ensure that a **logging utility class** has only one instance throughout the application lifecycle for consistent logging.

### 🔑 Key Concepts
- **Private static instance** of the class itself
- **Private constructor** to prevent external instantiation
- **Public static `getInstance()` method** with thread-safe double-checked locking

### 🏗️ How It Works
```
Logger.getInstance()  →  Creates instance only ONCE
Logger.getInstance()  →  Returns the SAME instance
```

### ▶️ How to Run
```bash
cd "WEEK-1/Design principles & Patterns/Singleton_plateform"
javac Logger.java SingletonPatternTest.java
java SingletonPatternTest
```

### ✅ Expected Output
```
Logger instance created.
[LOG] This is the first log message.
[LOG] This is the second log message.

--- Singleton Verification ---
logger1 hashCode: 980546781
logger2 hashCode: 980546781
Both logger1 and logger2 are the SAME instance. Singleton works!
```

---

## Exercise 2: Factory Method Pattern

### 📌 Scenario
Develop a **document management system** that creates different types of documents (Word, PDF, Excel) using the Factory Method Pattern.

### 🔑 Key Concepts
- **Document Interface** — defines common operations (`open()`, `save()`, `close()`)
- **Concrete Document Classes** — `WordDocument`, `PdfDocument`, `ExcelDocument`
- **Abstract Factory** (`DocumentFactory`) — declares `createDocument()` method
- **Concrete Factories** — each factory creates a specific document type

### 🏗️ Class Diagram
```
          Document (Interface)
         /        |          \
WordDocument  PdfDocument  ExcelDocument

       DocumentFactory (Abstract)
         /        |            \
WordDocFactory  PdfDocFactory  ExcelDocFactory
```

### ▶️ How to Run
```bash
cd "WEEK-1/Design principles & Patterns/Factory Method Pattern"
javac *.java
java FactoryMethodPatternTest
```

### ✅ Expected Output
```
--- Word Document ---
Opening Word Document...
Saving Word Document...
Closing Word Document...

--- PDF Document ---
Opening PDF Document...
Saving PDF Document...
Closing PDF Document...

--- Excel Document ---
Opening Excel Document...
Saving Excel Document...
Closing Excel Document...
```

---

## 📚 Design Patterns Summary

| Pattern | Type | Purpose |
|---------|------|---------|
| **Singleton** | Creational | Ensures only ONE instance of a class exists |
| **Factory Method** | Creational | Delegates object creation to subclasses |

---

## 🛠️ Prerequisites
- Java JDK 8 or above
- Any IDE (VS Code, IntelliJ, Eclipse) or terminal
