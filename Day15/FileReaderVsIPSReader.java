import java.io.*;
public class FileReaderVsIPSReader {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with the actual file path

        // Measure time for FileReader
        long startTime = System.nanoTime();
        int fileReaderWordCount = countWordsUsingFileReader(filePath);
        long endTime = System.nanoTime();
        System.out.println("FileReader - Word Count: " + fileReaderWordCount + " | Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure time for InputStreamReader
        startTime = System.nanoTime();
        int inputStreamReaderWordCount = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader - Word Count: " + inputStreamReaderWordCount + " | Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to count words using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split on whitespace
            }

        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    // Method to count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split on whitespace
            }

        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
