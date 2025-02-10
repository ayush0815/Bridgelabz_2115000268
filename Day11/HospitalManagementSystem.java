import java.util.ArrayList;
import java.util.List;

// Interface for managing patient medical records
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// Abstract class representing a patient
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;
    private List<String> records;  // Stores medical records

    public Patient(int patientId, String name, int age, String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
        this.records = new ArrayList<>();
    }

    // Getters (Encapsulation - protects sensitive data)
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    public String getMedicalHistory() { return medicalHistory; }

    // Method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
    }

    // Abstract method for bill calculation
    public abstract double calculateBill();

    // Implementing methods from MedicalRecord interface
    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// Concrete class for InPatient (hospitalized patient)
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyCharge;
    private double medicationCost;

    public InPatient(int patientId, String name, int age, String diagnosis, String medicalHistory,
                     int daysAdmitted, double dailyCharge, double medicationCost) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicationCost = medicationCost;
    }

    @Override
    public double calculateBill() {
        return (daysAdmitted * dailyCharge) + medicationCost;
    }
}

// Concrete class for OutPatient (consultation-based patient)
class OutPatient extends Patient {
    private double consultationFee;
    private double testCost;

    public OutPatient(int patientId, String name, int age, String diagnosis, String medicalHistory,
                      double consultationFee, double testCost) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.consultationFee = consultationFee;
        this.testCost = testCost;
    }

    @Override
    public double calculateBill() {
        return consultationFee + testCost;
    }
}

// Main class to test the Hospital Patient Management System
public class HospitalManagementSystem {
    public static void processPatients(Patient[] patients) {
        System.out.println("\n--- Patient Billing Summary ---");

        for (Patient patient : patients) {
            patient.getPatientDetails();
            double totalBill = patient.calculateBill();
            System.out.println("Total Bill: Rs" + totalBill);

            // Display medical records if any
            if (!patient.viewRecords().isEmpty()) {
                System.out.println("Medical Records: " + patient.viewRecords());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating patient instances
        Patient p1 = new InPatient(101, "Rahul Sharma", 45, "Diabetes", "Hypertension",
                                   5, 2000, 5000);
        Patient p2 = new OutPatient(102, "Priya Mehta", 30, "Flu", "No prior history",
                                    800, 1200);
        Patient p3 = new InPatient(103, "Amit Verma", 60, "Heart Disease", "Previous surgery",
                                   10, 1800, 7000);
        Patient p4 = new OutPatient(104, "Sneha Kapoor", 25, "Migraine", "Family history",
                                    1000, 1500);

        // Adding medical records
        p1.addRecord("Insulin dose adjusted on 10/02/2025.");
        p2.addRecord("Prescribed antibiotics.");
        p3.addRecord("Post-surgery checkup completed.");
        p4.addRecord("MRI scan recommended.");

        // Storing patients in an array
        Patient[] patients = {p1, p2, p3, p4};

        // Processing patient bills
        processPatients(patients);
    }
}
