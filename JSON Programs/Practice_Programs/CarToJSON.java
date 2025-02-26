import org.json.JSONObject;
import java.util.Scanner;

class Car {
    String brand, model;
    int year;

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarToJSON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter car model: ");
        String model = sc.nextLine();
        System.out.print("Enter car year: ");
        int year = sc.nextInt();

        Car car = new Car(brand, model, year);
        JSONObject jsonCar = new JSONObject(car);

        System.out.println("Car JSON: " + jsonCar.toString(2));
        sc.close();
    }
}
