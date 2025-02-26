import org.json.JSONObject;
import java.util.Scanner;

public class MergeJSONObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();

        System.out.print("Enter first object key: ");
        String key1 = sc.next();
        System.out.print("Enter first object value: ");
        String value1 = sc.next();
        json1.put(key1, value1);

        System.out.print("Enter second object key: ");
        String key2 = sc.next();
        System.out.print("Enter second object value: ");
        String value2 = sc.next();
        json2.put(key2, value2);

        json1.putAll(json2);
        System.out.println("Merged JSON: " + json1.toString(2));

        sc.close();
    }
}
