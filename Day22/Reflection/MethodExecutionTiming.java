package Reflection;
import java.lang.reflect.Method;

class SampleClass {
    public void methodA() {
       
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method A executed");
    }

    public void methodB() {
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method B executed");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) {
        try {
            SampleClass sample = new SampleClass();
            Method[] methods = SampleClass.class.getDeclaredMethods();

            for (Method method : methods) {
                long startTime = System.nanoTime();
                method.invoke(sample);
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;

                System.out.println("Execution time of " + method.getName() + ": " + executionTime + " nanoseconds");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}