class Device {
    String deviceId;
    boolean status; // true for on, false for off

    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "On" : "Off"));
    }

    @Override
    public String toString() {
        return "Device [deviceId=" + deviceId + ", status=" + status + "]";
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    public Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus(); // Call superclass method
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }

    @Override
    public String toString() {
        return "Thermostat [" + super.toString() + ", temperatureSetting=" + temperatureSetting + "]";
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("T123", true, 22.5);
        System.out.println(thermostat); // Uses the overridden toString()
        thermostat.displayStatus();

        Device genericDevice = new Device("D456", false);  // You can still create a Device object
        System.out.println(genericDevice);
        genericDevice.displayStatus();
    }
}