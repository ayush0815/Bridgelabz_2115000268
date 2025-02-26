import org.json.JSONObject;

public class ValidateEmail {
    public static void main(String[] args) {
        JSONObject user = new JSONObject();
        user.put("email", "example@gmail.com");

        if (user.getString("email").matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Valid email: " + user.getString("email"));
        } else {
            System.out.println("Invalid email");
        }
    }
}
