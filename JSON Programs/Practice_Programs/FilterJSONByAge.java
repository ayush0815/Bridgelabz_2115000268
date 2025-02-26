import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterJSONByAge {
    public static void main(String[] args) {
        String filePath = "data.json"; // Change this to your JSON file path

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);
            JSONArray filteredArray = new JSONArray();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject person = jsonArray.getJSONObject(i);
                if (person.has("age") && person.getInt("age") > 25) {
                    filteredArray.put(person);
                }
            }

            System.out.println("Filtered JSON (age > 25): " + filteredArray.toString(2));
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
