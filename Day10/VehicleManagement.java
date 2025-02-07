// Superclass
class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}
// Interface (Refuelable)
interface Refuelable {
    void refuel();
}
// Subclass EV
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println(model + " is charging...");
    }
}
// Subclass PetrolVehicle implementing Refuelable interface
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling...");
    }
}
class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(250, "Mahindra EV BE6");
        PetrolVehicle pv = new PetrolVehicle(230, "Tata Hexa");
        ev.displayInfo();
        ev.charge();
        pv.displayInfo();
        pv.refuel();
    }
}
