import java.io.*;
public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(14);
            dos.writeUTF("Ayush");
            dos.writeDouble(7.8);

            dos.writeInt(15);
            dos.writeUTF("Vaibhav");
            dos.writeDouble(8.2);

            System.out.println("Student data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

        // Reading student data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
