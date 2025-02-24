package Reflection;
import java.lang.reflect.Field;
import java.util.*;

public class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, Object> jsonMap = new HashMap<>();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                jsonMap.put(field.getName(), field.get(obj));
            }
            return jsonMap.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{}";
    }
}