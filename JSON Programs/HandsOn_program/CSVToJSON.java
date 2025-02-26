import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVToJSON {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("data.csv"));
            String[] headers = lines.get(0).split(",");
            JSONArray jsonArray = new JSONArray();

            for (int i = 1; i < lines.size(); i++) {
                String[] values = lines.get(i).split(",");
                JSONObject obj = new JSONObject();
                for (int j = 0; j < headers.length; j++) {
                    obj.put(headers[j], values[j]);
                }
                jsonArray.put(obj);
            }

            System.out.println(jsonArray.toString(2));
        } catch (Exception e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}
