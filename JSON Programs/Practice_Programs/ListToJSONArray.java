import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class ListToJSONArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();
            System.out.print("Enter employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            employees.add(new Employee(name, id));
        }

        JSONArray jsonArray = new JSONArray();
        for (Employee emp : employees) {
            JSONObject obj = new JSONObject();
            obj.put("name", emp.name);
            obj.put("id", emp.id);
            jsonArray.put(obj);
        }

        System.out.println("JSON Array: " + jsonArray.toString(2));
        sc.close();
    }
}
