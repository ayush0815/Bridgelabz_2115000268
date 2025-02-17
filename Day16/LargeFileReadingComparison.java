import java.io.*;
public class LargeFileReadingComparison {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Change this to your actual file path

        // Test FileReader (Character Stream)
        System.out.println("Reading with FileReader...");
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {} // Read character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
        long fileReaderTime = System.nanoTime() - startTime;
        System.out.println("FileReader Time: " + (fileReaderTime / 1_000_000.0) + " ms\n");

        // Test InputStreamReader (Byte Stream)
        System.out.println("Reading with InputStreamReader...");
        startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {} // Read byte by byte and convert to character
        } catch (IOException e) {
            e.printStackTrace();
        }
        long inputStreamReaderTime = System.nanoTime() - startTime;
        System.out.println("InputStreamReader Time: " + (inputStreamReaderTime / 1_000_000.0) + " ms");
    }
}
