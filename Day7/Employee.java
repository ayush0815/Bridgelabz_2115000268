public class Employee {
    public String employeeID;
    protected String department;
    private double salary;

    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void modifySalary(double newSalary) {
        salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {

    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        Manager manager = new Manager("M007", "Delivery", 100000.0);
        manager.displayInfo();
        manager.modifySalary(85000.0);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}

