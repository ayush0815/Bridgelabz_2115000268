package Reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Author Name")
class AnnotatedClass {
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        try {
            Class<?> clazz = AnnotatedClass.class;
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}