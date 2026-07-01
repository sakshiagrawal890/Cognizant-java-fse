# Exercise 1: Configuring a Basic Spring Application

## Goal
Set up a basic Maven project configuring Spring IoC Container using XML-based configuration (`applicationContext.xml`).

## Project Structure
- `pom.xml`: Includes Maven dependencies for `spring-core` and `spring-context`.
- `applicationContext.xml`: Declares beans for `BookService` and `BookRepository`.
- `BookRepository.java` & `BookService.java`: Service and repository components managed by Spring.
- `LibraryManagementApplication.java`: Loads the Spring Context and retrieves the `BookService` bean.

## How to Run

Execute from this directory using the local Maven:
```bash
../../../../../.maven/apache-maven-3.9.6/bin/mvn exec:java '-Dexec.mainClass=com.library.LibraryManagementApplication'
```
