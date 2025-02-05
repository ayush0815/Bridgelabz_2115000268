import java.util.ArrayList;
class Patient {
    String name;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient: " + name;
    }
}

class Doctor {
    String name;
    ArrayList<Patient> patients; // Association

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void consult(Patient patient) {  // Communication
        System.out.println("Dr. " + name + " is consulting with " + patient.name);
    }

    public void viewPatients() {
        System.out.println("Dr. " + name + "'s patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}

class Hospital {
    String name;
    ArrayList<Doctor> doctors;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void displayDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor doctor : doctors) {
            doctor.viewPatients();
        }
    }
}


public class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Max Hospital");
        Doctor drSwadesh = new Doctor("Swadesh Singh");
        Doctor drNakul = new Doctor("Nakul Sinha");

        Patient ayush = new Patient("Ayush");
        Patient aviral = new Patient("Aviral");

        drSwadesh.addPatient(ayush);
        drSwadesh.addPatient(aviral);
        drNakul.addPatient(aviral); // Bob consults both doctors

        hospital.addDoctor(drSwadesh);
        hospital.addDoctor(drNakul);

        hospital.displayDoctors();

        drSwadesh.consult(ayush);
        drNakul.consult(aviral);
    }
}