import java.util.ArrayList;
class Faculty {
    String name;
    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty: " + name;
    }
}

class Department {
    String name;
    ArrayList<Faculty> faculties;

    public Department(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }

    public void displayFaculties() {
        System.out.println("Faculties in " + name + ":");
        for (Faculty faculty : faculties) {
            System.out.println(faculty);
        }
    }
}

class University {
    String name;
    ArrayList<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void displayDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department department : departments) {
            department.displayFaculties();
        }
    }

    public void deleteUniversity() {
        departments.clear();
        System.out.println("University " + name + " and its departments have been deleted.");
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University university = new University("Example University");
        Department scienceDept = new Department("Science");
        Department artsDept = new Department("Arts");

        Faculty prof1 = new Faculty("Dr. Lekhraj");
        Faculty prof2 = new Faculty("Dr. Law Kumar");

        scienceDept.addFaculty(prof1);
        artsDept.addFaculty(prof2);

        university.addDepartment(scienceDept);
        university.addDepartment(artsDept);

        university.displayDepartments();

        university.deleteUniversity(); // Demonstrates Composition
    }
}