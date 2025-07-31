package SOLID_Principles;

// BAD EXAMPLE - Violates SRP (Multiple responsibilities in one class)
class BadEmployee {
    private String name;
    private double salary;
    
    public BadEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    // Responsibility 1: Employee data management
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    // Responsibility 2: Salary calculation (should be separate)
    public double calculateTax() {
        return salary * 0.2; // 20% tax
    }
    
    // Responsibility 3: Data persistence (should be separate)
    public void saveToDatabase() {
        System.out.println("Saving " + name + " to database...");
    }
    
    // Responsibility 4: Report generation (should be separate)
    public void generatePayslip() {
        System.out.println("Generating payslip for " + name);
    }
}

// GOOD EXAMPLE - Follows SRP (Single responsibility per class)

// Responsibility 1: Employee data management
class Employee {
    private String name;
    private double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    public double getSalary() { return salary; }
}

// Responsibility 2: Tax calculation
class TaxCalculator {
    public double calculateTax(Employee employee) {
        return employee.getSalary() * 0.2; // 20% tax
    }
}

// Responsibility 3: Data persistence
class EmployeeRepository {
    public void save(Employee employee) {
        System.out.println("Saving " + employee.getName() + " to database...");
    }
}

// Responsibility 4: Report generation
class PayslipGenerator {
    public void generatePayslip(Employee employee) {
        System.out.println("Generating payslip for " + employee.getName());
        System.out.println("Salary: $" + employee.getSalary());
    }
}

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Single Responsibility Principle Demo ===\n");
        
        // Using the GOOD design (SRP compliant)
        Employee emp = new Employee("John Doe", 5000);
        
        TaxCalculator taxCalc = new TaxCalculator();
        EmployeeRepository empRepo = new EmployeeRepository();
        PayslipGenerator payslipGen = new PayslipGenerator();
        
        System.out.println("Employee: " + emp.getName());
        System.out.println("Tax: $" + taxCalc.calculateTax(emp));
        
        empRepo.save(emp);
        payslipGen.generatePayslip(emp);
        
        System.out.println("\nBenefits of SRP:");
        System.out.println("1. Each class has only one reason to change");
        System.out.println("2. Easy to maintain and test");
        System.out.println("3. Classes are more focused and cohesive");
        System.out.println("4. Better code reusability");
    }
}
