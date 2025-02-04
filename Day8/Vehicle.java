class Vehicle {
    static double registrationFee = 1000.0; // Shared registration fee for all vehicles
    final private String registrationNumber; // Unique registration number
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this' keyword
    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Static method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display vehicle details
    void display() {
        System.out.println("\nRegistration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: Rs" + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("BH24 9135", "Ayush Srivastava", "Car");
        Vehicle vehicle2 = new Vehicle("BH 24 3444", "Aviral Singh", "Motorcycle");

        // Checking instanceof before processing
        if (vehicle1 instanceof Vehicle) {
            System.out.println("\nvehicle1 is an instance of Vehicle class");
            vehicle1.display();
        }

        if (vehicle2 instanceof Vehicle) {
            System.out.println("\nvehicle2 is an instance of Vehicle class");
            vehicle2.display();
        }

        // Updating registration fee
        Vehicle.updateRegistrationFee(1350.0);
        System.out.println("\nUpdated Registration Fee for all vehicles: Rs" + Vehicle.registrationFee);
    }
}
