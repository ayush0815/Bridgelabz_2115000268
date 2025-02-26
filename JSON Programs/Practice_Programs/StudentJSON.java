import org.json.JSONObject;
import java.util.Scanner;

public class StudentJSON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter subjects (comma-separated): ");
        String[] subjects = sc.nextLine().split(",");

        JSONObject student = new JSONObject();
        student.put("name", name);
        student.put("age", age);
        student.put("subjects", subjects);

        System.out.println("Student JSON: " + student.toString(2));
        sc.close();
    }
}
