class Vehicle{
    private String ownerName;
    private String vehicleType;

    private static int registrationFee=500;

    Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails(){
        System.out.println("\nOwner of this vehicle is: " + this.ownerName);
        System.out.println("type of vehicle: " + this.vehicleType);
    }

    static void updateRegistrationFee(int fee){
        registrationFee = fee;
        System.out.println("\nRegistration fee updated to:" + registrationFee);
    }

    public static void main(String[] args){
        Vehicle vehicle1 = new Vehicle("Ayush Srivastava", "SUV");
        Vehicle vehicle2 = new Vehicle("Aviral Singh", "Sedan");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(450);
    }
}

