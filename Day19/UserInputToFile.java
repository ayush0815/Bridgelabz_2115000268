import java.io.*;
public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("user_data.txt", true)) {

            System.out.print("Enter your name");
            String name = reader.readLine();

            System.out.print("Enter your age");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Enter your favorite programming language");
            String language = reader.readLine();

            writer.write("Name: " + name + "\nAge: " + age + "\nLanguage: " + language + "\n\n");
            System.out.println("Data saved successfully");

        } catch (IOException e) {
            System.out.println("Error handling input/output" + e.getMessage());
        }
    }
}
