import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

class Employee {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJSON {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Amit", 30));
        employees.add(new Employee("Rahul", 25));

        JSONArray jsonArray = new JSONArray();
        for (Employee emp : employees) {
            JSONObject obj = new JSONObject();
            obj.put("name", emp.name);
            obj.put("age", emp.age);
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString(2));
    }
}
