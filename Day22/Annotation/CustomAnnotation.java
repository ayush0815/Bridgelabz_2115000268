package Annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}


class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void task1() {
        System.out.println("Task 1 details.");
    }
}


public class CustomAnnotation {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        Method method = taskManager.getClass().getMethod("task1");
        
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
        if (taskInfo != null) {
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}