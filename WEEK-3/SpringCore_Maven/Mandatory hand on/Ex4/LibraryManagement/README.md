# Exercise 4: Creating and Configuring a Maven Project

## Goal
Configure a Maven project adding multiple Spring framework ecosystem dependencies (Context, AOP, WebMVC) and configuring compiler level to Java 1.8.

## Configuration Details
- `pom.xml`: Includes dependencies:
  - `spring-context`
  - `spring-aop`
  - `spring-webmvc`
- Configured `maven-compiler-plugin` for Java source and target compiler level `1.8`.

## How to Compile

Execute from this directory using the local Maven:
```bash
../../../../../.maven/apache-maven-3.9.6/bin/mvn clean compile
```
