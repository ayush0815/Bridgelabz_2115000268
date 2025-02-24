package Reflection;
import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            Field field = Person.class.getDeclaredField("age");
            field.setAccessible(true);

            System.out.println("Original age: " + field.getInt(person));
            field.setInt(person, 30);
            System.out.println("Modified age: " + field.getInt(person));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}