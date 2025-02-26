import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterJSON {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("users.json")));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                if (user.getInt("age") > 25) {
                    System.out.println(user);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}
