# Simple Maven Project

This is a basic Maven project demonstrating the standard Maven directory structure and lifecycle.

## Project Structure
```
Maven/
├── pom.xml                           # Maven configuration file
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── Calculator.java    # Main Java class
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── CalculatorTest.java # Unit tests
└── README.md                         # This file
```

## What This Project Contains

- **Calculator.java**: A simple calculator class with basic arithmetic operations
- **CalculatorTest.java**: JUnit tests for the calculator
- **pom.xml**: Maven configuration with dependencies and build settings

## How to Build and Run

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Commands

1. **Compile the project:**
   ```
   mvn compile
   ```

2. **Run tests:**
   ```
   mvn test
   ```

3. **Package into JAR:**
   ```
   mvn package
   ```

4. **Run the main class:**
   ```
   mvn exec:java -Dexec.mainClass="com.example.Calculator"
   ```
   
   Or after packaging:
   ```
   java -cp target/simple-maven-project-1.0.0.jar com.example.Calculator
   ```

5. **Clean build artifacts:**
   ```
   mvn clean
   ```

## Maven Lifecycle Phases

- `validate` - validate the project is correct
- `compile` - compile the source code
- `test` - test the compiled source code using a suitable unit testing framework
- `package` - take the compiled code and package it in its distributable format (JAR)
- `verify` - run any checks on results of integration tests
- `install` - install the package into the local repository
- `deploy` - copy the final package to the remote repository

## Expected Output

When you run the Calculator main method, you should see:
```
=== Simple Calculator Demo ===
5 + 3 = 8
10 - 4 = 6
6 * 7 = 42
Calculator demo completed!
```
