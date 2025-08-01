# Coffee Machine Simulation - Spring Core

A simple Spring Core application demonstrating IoC, DI, Bean Scopes, Lifecycle methods, and AOP.

## 🎯 Features Implemented

### ✅ Interfaces and Implementations
- `CoffeeMachine` interface
- `EspressoMachine` (Singleton) with `@Component("espressoMachine")`
- `LatteMachine` (Prototype) with `@Component("latteMachine")`

### ✅ Dependency Injection
- `CafeService` with **Constructor Injection**
- Uses `@Autowired` and `@Qualifier("espressoMachine")`

### ✅ Bean Scopes
- **EspressoMachine**: `@Scope("singleton")` - same instance reused
- **LatteMachine**: `@Scope("prototype")` - new instance each time
- Constructor print statements show the difference

### ✅ Bean Lifecycle
- `@PostConstruct` in `EspressoMachine` and `CafeService`
- `@PreDestroy` in `CafeService`
- Console output shows lifecycle events

### ✅ Aspect-Oriented Programming (AOP)
- `LoggerAspect` with `@Aspect`
- `@Before` and `@After` advice on `CafeService.makeCoffee()`
- Method execution logging

## 🚀 How to Run

### Prerequisites
- Java 11+
- Maven 3.6+

### Commands

1. **Navigate to project directory:**
   ```bash
   cd coffee-machine
   ```

2. **Compile:**
   ```bash
   mvn compile
   ```

3. **Run the application:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.cafe.CoffeeMachineApp"
   ```

## 📋 Expected Output

```
☕ === Coffee Machine Simulation Started ===
🔧 EspressoMachine Constructor Called - Singleton Bean Created
☕ EspressoMachine @PostConstruct - Bean Initialized
🏗️ CafeService Constructor - Dependency Injected: Espresso Machine
🚀 CafeService @PostConstruct - Service Ready!

--- Testing Singleton vs Prototype Beans ---
CafeService instances same? true
🔧 LatteMachine Constructor Called - Prototype Bean Created
🔧 LatteMachine Constructor Called - Prototype Bean Created
LatteMachine instances same? false

--- Testing Coffee Making with AOP ---
🔍 [AOP @Before] Starting coffee preparation...
📋 CafeService.makeCoffee() - Processing order...
✅ [AOP @After] Coffee preparation completed!
Result: Making Espresso ☕

--- Testing Different Coffee Types ---
Latte: Making Latte ☕🥛

--- Shutting Down ---
🛑 CafeService @PreDestroy - Service Shutting Down!
☕ === Coffee Machine Simulation Ended ===
```

## 🏗️ Project Structure

```
coffee-machine/
├── pom.xml
├── src/main/java/com/cafe/
│   ├── CoffeeMachine.java         # Interface
│   ├── EspressoMachine.java       # Singleton implementation
│   ├── LatteMachine.java          # Prototype implementation
│   ├── CafeService.java           # Service with DI
│   ├── LoggerAspect.java          # AOP aspect
│   ├── AppConfig.java             # Spring configuration
│   └── CoffeeMachineApp.java      # Main application
└── README.md
```

## 🎯 Learning Objectives Covered

1. **@Component, @Service** - Bean registration
2. **@Autowired, @Qualifier** - Dependency injection
3. **@Scope** - Singleton vs Prototype beans
4. **@PostConstruct, @PreDestroy** - Lifecycle methods
5. **@Aspect, @Before, @After** - AOP implementation
6. **Constructor Injection** - Best practice DI
7. **Spring Configuration** - Java-based config
