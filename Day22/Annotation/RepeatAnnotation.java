package Annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "Null pointer exception occurs")
    @BugReport(description = "Array index out of bounds")
    public void trackBugs() {
        System.out.println("Tracking bugs...");
    }
}

public class RepeatAnnotation {
    public static void main(String[] args) throws Exception {
        BugTracker bugTracker = new BugTracker();
        Method method = bugTracker.getClass().getMethod("trackBugs");
        
        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
        for (BugReport bugReport : bugReports) {
            System.out.println("Bug Report: " + bugReport.description());
        }
    }
}