import java.util.ArrayList;
class Course {
    String name;
    Professor professor; // Association
    ArrayList<Student> students; // Association

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this); // Maintain consistency
    }

    public void enrollStudent(Student student) {
        this.students.add(student);
        student.enrollCourse(this); // Maintain consistency
    }


    @Override
    public String toString() {
        return "Course: " + name;
    }
}

class Professor {
    String name;
    ArrayList<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void viewCourses() {
        System.out.println("Professor " + name + " teaches:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return "Professor: " + name;
    }
}

class Student {
    String name;
    ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        this.courses.add(course);
    }

    public void viewEnrolledCourses() {
        System.out.println("Student " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        Professor profMath = new Professor("Dr. Pooja");
        Professor profSci = new Professor("Dr. Abhishek");

        Student ayush = new Student("Ayush");
        Student aviral = new Student("Aviral");

        Course calculus = new Course("Calculus");
        Course physics = new Course("Physics");

        calculus.assignProfessor(profMath);
        physics.assignProfessor(profSci);

        calculus.enrollStudent(ayush);
        calculus.enrollStudent(aviral);
        physics.enrollStudent(ayush);

        profMath.viewCourses();
        ayush.viewEnrolledCourses();
    }
}