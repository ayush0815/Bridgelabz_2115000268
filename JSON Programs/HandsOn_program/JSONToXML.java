import org.json.JSONObject;
import org.json.XML;

public class JSONToXML {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Amit\", \"age\": 30 }";
        JSONObject jsonObject = new JSONObject(jsonString);
        String xml = XML.toString(jsonObject);
        System.out.println("XML Format:\n" + xml);
    }
}
