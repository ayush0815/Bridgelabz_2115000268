import java.util.ArrayList;
class Employee {
    String name;
    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee: " + name;
    }
}

class Department {
    String name;
    ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void displayEmployees() {
        System.out.println("Employees in " + name + ":");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Company {
    String name;
    ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void displayDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department department : departments) {
            department.displayEmployees();
        }
    }

    // When a company is deleted, its departments and employees should be deleted as well (Composition)
    public void deleteCompany() {
        departments.clear(); // Departments are removed
        System.out.println("Company " + name + " and its departments have been deleted.");
    }
}

public class CompanyDemo {
    public static void main(String[] args) {
        Company company = new Company("Capgemini");
        Department sales = new Department("Sales");
        Department marketing = new Department("Marketing");

        sales.addEmployee(new Employee("Ayush"));
        sales.addEmployee(new Employee("Aviral"));
        marketing.addEmployee(new Employee("Karan"));

        company.addDepartment(sales);
        company.addDepartment(marketing);

        company.displayDepartments();

        company.deleteCompany();  // Demonstrates composition
    }
}