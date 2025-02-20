import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}
public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Ayush", "Sales", 50000));
        employees.add(new Employee(102, "Vaibhav", "IT", 60000));
        employees.add(new Employee(103, "Aditya", "Finance", 55000));

        String fileName = "employees.ser";

        // Serialize the employees list
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");

        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialize the employees list
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
