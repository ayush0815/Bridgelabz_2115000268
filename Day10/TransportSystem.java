class Vehicle {
    int maxSpeed;
    String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }

    @Override
    public String toString() {
        return "Vehicle [maxSpeed=" + maxSpeed + ", fuelType=" + fuelType + "]";
    }
}

class Car extends Vehicle {
    int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }

    @Override
    public String toString() {
        return "Car [" + super.toString() + ", seatCapacity=" + seatCapacity + "]";
    }
}

class Truck extends Vehicle {
    double loadCapacity;

    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }

    @Override
    public String toString() {
        return "Truck [" + super.toString() + ", loadCapacity=" + loadCapacity + "]";
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
    }

    @Override
    public String toString() {
        return "Motorcycle [" + super.toString() + ", hasSidecar=" + hasSidecar + "]";
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(200, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 15.0);
        vehicles[2] = new Motorcycle(180, "Petrol", false);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle); // Polymorphism in action: toString() of the actual object is called.
            vehicle.displayInfo(); // Polymorphism: displayInfo() of the actual object is called.
            System.out.println("---");
        }
    }
}