import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class ReadJSONKeysValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "data.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                System.out.println(key + ": " + jsonObject.get(key));
            }
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }

        sc.close();
    }
}
