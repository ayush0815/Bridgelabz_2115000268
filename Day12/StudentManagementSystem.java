class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Add a student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add a student at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add a student at a specific position (1-based index)
    public void addAtPosition(int rollNumber, String name, int age, char grade, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete a student by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Student temp = head;
        Student prev = null;

        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found!");
            return;
        }

        prev.next = temp.next;
    }

    // Search for a student by Roll Number
    public Student searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display all student records
    public void displayRecords() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update student grade by Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}

// Driver Code
public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Adding students
        studentList.addAtEnd(14, "Ayush", 22, 'A');
        studentList.addAtEnd(49, "Vaibhav", 21, 'B');
        studentList.addAtBeginning(04, "Aditya", 22, 'C');
        studentList.addAtPosition(48, "Uttam", 22, 'D', 2);

        // Display all records
        studentList.displayRecords();

        // Searching for a student
        Student foundStudent = studentList.searchByRollNumber(49);
        if (foundStudent != null) {
            System.out.println("\nStudent Found: " + foundStudent.name + " (Roll No: " + foundStudent.rollNumber + ")");
        } else {
            System.out.println("\nStudent not found!");
        }

        // Updating a grade
        studentList.updateGrade(48, 'A');
        studentList.displayRecords();

        // Deleting a student
        studentList.deleteByRollNumber(04);
        studentList.displayRecords();
    }
}
