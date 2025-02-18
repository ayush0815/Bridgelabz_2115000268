import java.util.ArrayList;
import java.util.List;

// Abstract CourseType Class 
abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
// Specific course types
class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
}
// Generic course class which manages different course types)
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " [" + department + "] - " + courseType.getName();
    }
}
// Course management system which handles multiple course types using Wildcards)
class CourseManagement {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("University Courses:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}
public class UniversityCourseSystem {
    public static void main(String[] args) {
        CourseManagement courseManagement = new CourseManagement();

        // Creating course types
        ExamCourse examType = new ExamCourse("Final Exam");
        AssignmentCourse assignmentType = new AssignmentCourse("Project Submission");
        ResearchCourse researchType = new ResearchCourse("Thesis Submission");

        // Creating courses for different departments
        Course<ExamCourse> mathExam = new Course<>("Calculas", "Mathematics", examType);
        Course<AssignmentCourse> csProject = new Course<>("Software Engineering", "Computer Science", assignmentType);
        Course<ResearchCourse> physicsResearch = new Course<>("Quantum Physics", "Physics", researchType);

        // Adding courses to the system
        courseManagement.addCourse(mathExam);
        courseManagement.addCourse(csProject);
        courseManagement.addCourse(physicsResearch);

        // Display all courses
        courseManagement.displayCourses();
    }
}
