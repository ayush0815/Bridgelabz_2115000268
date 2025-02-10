// Interface for GPS tracking
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
// Abstract class representing a vehicle
abstract class Vehicle implements GPS {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(int vehicleId, String driverName, double ratePerKm, String initialLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = initialLocation;
    }

    // Getters (Encapsulation)
    public int getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate: Rs" + ratePerKm + "/km");
    }

    // Implementing GPS interface methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Concrete class for Car
class Car extends Vehicle {
    private double baseFare = 50; // Minimum charge for car rides

    public Car(int vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (getRatePerKm() * distance);
    }
}

// Concrete class for Bike
class Bike extends Vehicle {
    private double helmetCharge = 10; // Additional charge for helmet

    public Bike(int vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + helmetCharge;
    }
}

// Concrete class for Auto (Rickshaw)
class Auto extends Vehicle {
    private double nightCharge = 20; // Additional charge for night rides

    public Auto(int vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + nightCharge;
    }
}
class RideHailingApp {
    public static void processRides(Vehicle[] vehicles, double distance) {
        System.out.println("\n--- Ride Fare Summary ---");

        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            double fare = vehicle.calculateFare(distance);
            System.out.println("Estimated Fare for " + distance + " km: Rs" + fare);
            System.out.println("Current Location: " + vehicle.getCurrentLocation() + "\n");
        }
    }
    public static void main(String[] args) {
        Vehicle v1 = new Car(101, "Rajesh Kumar", 12, "Connaught Place");
        Vehicle v2 = new Bike(102, "Amit Sharma", 5, "Lajpat Nagar");
        Vehicle v3 = new Auto(103, "Vikram Singh", 8, "Karol Bagh");

        // Updating vehicle locations dynamically
        v1.updateLocation("Rajiv Chowk");
        v2.updateLocation("Saket Metro");
        v3.updateLocation("Chandni Chowk");

        // Storing vehicles in an array
        Vehicle[] vehicles = {v1, v2, v3};

        // Simulate ride fare calculations for a 10 km ride
        processRides(vehicles, 10);
    }
}
