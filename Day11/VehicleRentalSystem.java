// Interface for insurance-related operations
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class representing a Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Setter for rentalRate (encapsulation)
    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) {
            this.rentalRate = rentalRate;
        }
    }

    // Abstract method for rental cost calculation
    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Rental Rate: " + rentalRate);
    }
}

// Concrete class for Car (implements Insurable)
class Car extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.05; // 5% insurance charge

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    // Implementing abstract method
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Implementing Insurable methods
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: 5% of rental rate";
    }
}

// Concrete class for Bike (implements Insurable)
class Bike extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.02; // 2% insurance charge

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    // Implementing abstract method
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Implementing Insurable methods
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: 2% of rental rate";
    }
}

// Concrete class for Truck (implements Insurable)
class Truck extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.08; // 8% insurance charge

    // Constructor
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    // Implementing abstract method
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Implementing Insurable methods
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: 8% of rental rate";
    }
}

class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car("UP32AB1234", 2000);
        Vehicle v2 = new Bike("UP32XY5678", 500);
        Vehicle v3 = new Truck("UP70PQ9999", 4000);

        // Storing vehicles in an array
        Vehicle[] vehicles = {v1, v2, v3};

        // Processing vehicles using polymorphism
        int rentalDays = 5;
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insurance = (vehicle instanceof Insurable) ? ((Insurable) vehicle).calculateInsurance() : 0;

            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            System.out.println("Insurance Cost: " + insurance);

            // Display insurance details if applicable
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
            System.out.println();
        }
    }
}
