# Exercise 2: Implementing Dependency Injection

## Goal
Wire Spring beans using Setter-based Dependency Injection in XML-based configuration.

## Key Changes
- `BookService.java`: Added a reference property and setter method for `BookRepository`.
- `applicationContext.xml`: Wired `BookRepository` bean into the `BookService` bean using the `<property>` tag.
- `LibraryManagementApplication.java`: Runs and validates that `BookRepository` is successfully injected by Spring.

## How to Run

Execute from this directory using the local Maven:
```bash
../../../../../.maven/apache-maven-3.9.6/bin/mvn exec:java '-Dexec.mainClass=com.library.LibraryManagementApplication'
```
