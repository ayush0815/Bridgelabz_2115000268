package Reflection;
class Student {
    private String name;

    public Student() {
        this.name = "Default Name";
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}

public class CreateObjectDynamically {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Object student1 = clazz.getDeclaredConstructor().newInstance();
            Object student2 = clazz.getDeclaredConstructor(String.class).newInstance("John Doe");

            System.out.println(student1);
            System.out.println(student2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}