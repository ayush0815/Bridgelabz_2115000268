package Queue;
import java.util.*;
class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

// Comparator to sort patients by severity in descending order
class PatientComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.severity, p1.severity);
    }
}

class HospitalTriage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Patient> queue = new PriorityQueue<>(new PatientComparator());

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Input patient details
        for (int i = 0; i < n; i++) {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();
            System.out.print("Enter severity (higher is more critical): ");
            int severity = sc.nextInt();
            sc.nextLine(); // Consume newline
            queue.add(new Patient(name, severity));
        }

        // Treat patients based on priority
        System.out.println("Patients treated in order of severity:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().name);
        }
        sc.close();
    }
}
