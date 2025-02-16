import java.io.*;
public class ConsoleToFileWriter {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Change this if needed

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + System.lineSeparator()); // Write to file with a new line
            }

            System.out.println("Data successfully written to " + filePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
