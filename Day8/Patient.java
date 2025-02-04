class Patient {
    static String hospitalName = "AIIMS Raebareli"; // Shared hospital name for all patients
    static int totalPatients = 0; // Track total patients
    
    final private int patientID; // Unique patient ID
    private String name;
    private int age;
    private String ailment;

    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Static method to get total patients
    static int getTotalPatients() {
        return totalPatients;
    }

    // Method to display patient details
    void display() {
        System.out.println("\nPatient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Hospital: " + hospitalName);
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient(123, "ABC", 50, "Diabates");
        Patient patient2 = new Patient(456, "XYZ", 45, "Kidney Stone");

        // Checking instanceof before processing
        if (patient1 instanceof Patient) {
            System.out.println("\npatient1 is an instance of Patient class");
            patient1.display();
        }

        if (patient2 instanceof Patient) {
            System.out.println("\npatient2 is an instance of Patient class");
            patient2.display();
        }

        // Display total patients
        System.out.println("\nTotal Patients Admitted: " + Patient.getTotalPatients());
    }
}
