// Base class: Course
class Course {
    String courseName;
    int duration; // Duration in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass: OnlineCourse (inherits from Course)
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse (inherits from OnlineCourse)
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // Percentage discount

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getDiscountedPrice() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: Rs" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: Rs" + getDiscountedPrice());
    }
}

// Main class to test the hierarchy
public class CourseHierarchy {
    public static void main(String[] args) {
        PaidOnlineCourse poc = new PaidOnlineCourse("Java Programming", 40, "Udemy", true, 5000, 90);
        poc.displayInfo();
    }
}
