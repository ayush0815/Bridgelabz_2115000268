class Student {
    static String universityName = "GLA University"; // Shared university name
    static int totalStudents = 0; // Track total students
    
    final private int rollNumber; // Unique roll number
    private String name;
    private String grade;

    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Static method to display total students
    static void displayTotalStudents() {
        System.out.println("Total students enrolled: " + totalStudents);
    }

    // Method to display student details
    void display() {
        System.out.println("\nRoll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("University: " + universityName);
    }

    public static void main(String[] args) {
        Student student1 = new Student(268, "Ayush Srivastava", "A");
        Student student2 = new Student(077, "Vaibhav Singh", "A+");

        // Checking instanceof before processing
        if (student1 instanceof Student) {
            System.out.println("\nstudent1 is an instance of Student class");
            student1.display();
        }

        if (student2 instanceof Student) {
            System.out.println("\nstudent2 is an instance of Student class");
            student2.display();
        }

        // Display total students
        Student.displayTotalStudents();
    }
}
