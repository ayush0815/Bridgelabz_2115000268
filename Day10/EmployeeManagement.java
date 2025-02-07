class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {  
        return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
    }
}

class Manager extends Employee {
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the superclass method to display common details
        System.out.println("Team Size: " + teamSize);
    }

    @Override
    public String toString() {
        return "Manager [" + super.toString() + ", teamSize=" + teamSize + "]";
    }
}

class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }

    @Override
    public String toString() {
        return "Developer [" + super.toString() + ", programmingLanguage=" + programmingLanguage + "]";
    }
}

class Intern extends Employee {
    String university;

    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }

    @Override
    public String toString() {
        return "Intern [" + super.toString() + ", university=" + university + "]";
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Manager manager = new Manager("Ayush", 2612, 100000, 10);
        Developer developer = new Developer("Vaibhav", 1404, 90000, "Java");
        Intern intern = new Intern("Aviral", 1090, 80000, "GLA");

        System.out.println(manager);      // Uses the overridden toString()
        manager.displayDetails();
        System.out.println("---");

        System.out.println(developer);   // Uses the overridden toString()
        developer.displayDetails();
        System.out.println("---");

        System.out.println(intern);      // Uses the overridden toString()
        intern.displayDetails();
    }
}