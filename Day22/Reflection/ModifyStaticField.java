package Reflection;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OriginalKey";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Field field = Configuration.class.getDeclaredField("API_KEY");
            field.setAccessible(true);

            System.out.println("Original API_KEY: " + Configuration.getApiKey());
            field.set(null, "NewModifiedKey");
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}