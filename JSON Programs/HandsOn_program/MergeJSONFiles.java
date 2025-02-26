import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeJSONFiles {
    public static void main(String[] args) {
        try {
            String content1 = new String(Files.readAllBytes(Paths.get("file1.json")));
            String content2 = new String(Files.readAllBytes(Paths.get("file2.json")));

            JSONObject json1 = new JSONObject(content1);
            JSONObject json2 = new JSONObject(content2);

            json1.putAll(json2);
            System.out.println("Merged JSON: " + json1.toString(2));
        } catch (Exception e) {
            System.out.println("Error merging JSON files: " + e.getMessage());
        }
    }
}
