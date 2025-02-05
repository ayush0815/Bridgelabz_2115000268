import java.util.ArrayList;
class School {
    String name;
    ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSchool(this); // Establish the reverse association (Important!)
    }

    public void displayStudents() {
        System.out.println("Students at " + name + ":");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {
    String name;
    School school; // Aggregation (Student can exist without a school)
    ArrayList<Course> courses; // Association (Many-to-many with Course)

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void enrollCourse(Course course) {
        this.courses.add(course);
        course.addStudent(this); // Maintain consistency on both sides
    }

    public void viewEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}

class Course {
    String name;
    ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void viewEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        return "Course: " + name;
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        School school = new School("SJS Public School");
        Student ayush = new Student("Ayush");
        Student vaibhav = new Student("Vaibhav");

        school.addStudent(ayush);
        school.addStudent(vaibhav);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        ayush.enrollCourse(math);
        vaibhav.enrollCourse(math);
        vaibhav.enrollCourse(science);

        school.displayStudents();
        ayush.viewEnrolledCourses();
        math.viewEnrolledStudents();
    }
}