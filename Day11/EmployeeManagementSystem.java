// Interface defining department-related behavior
interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

// Abstract class representing an Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method for salary calculation (implemented in subclasses)
    public abstract double calculateSalary();

    // Concrete method to display employee details
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
    }
}

// Full-time employee class inheriting from Employee and implementing Department
class FullTimeEmployee extends Employee implements Department {
    private String department;

    // Constructor
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    // Implementing abstract method to calculate salary
    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary for full-time employees
    }

    // Implementing Department methods
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Part-time employee class inheriting from Employee and implementing Department
class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    private String department;

    // Constructor
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0); // Base salary is not applicable for part-time
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    // Implementing abstract method to calculate salary
    @Override
    public double calculateSalary() {
        return workHours * hourlyRate; // Salary based on hours worked
    }

    // Implementing Department methods
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main class to test Employee Management System
class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating employees
        Employee emp1 = new FullTimeEmployee(101, "Ayush", 50000);
        Employee emp2 = new PartTimeEmployee(102, "Aviral", 500, 20);

        // Assigning departments
        ((FullTimeEmployee) emp1).assignDepartment("HR");
        ((PartTimeEmployee) emp2).assignDepartment("IT");

        // Storing employees in an array
        Employee[] employees = {emp1, emp2};

        // Processing employees using polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: " + emp.calculateSalary());

            // Display department details if employee is a Department instance
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}
