import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadJSONFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "user.json"

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            System.out.println("Name: " + jsonObject.getString("name"));
            System.out.println("Email: " + jsonObject.getString("email"));
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }

        sc.close();
    }
}
