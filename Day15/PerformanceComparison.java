import java.io.*;
import java.util.StringTokenizer;
public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();
        compareFileReaderAndInputStreamReader("largefile.txt"); // Replace with the actual large file path
    }

    // Method to compare StringBuilder and StringBuffer for string concatenation
    private static void compareStringBuilderAndStringBuffer() {
        String text = "hello";
        int iterations = 1_000_000; // 1 million iterations

        // Measure performance of StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure performance of StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to compare FileReader and InputStreamReader for word count in a file
    private static void compareFileReaderAndInputStreamReader(String filePath) {
        long startTime, endTime;

        // Using FileReader
        startTime = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        endTime = System.nanoTime();
        System.out.println("FileReader - Word Count: " + wordCountFileReader + " | Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using InputStreamReader
        startTime = System.nanoTime();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader - Word Count: " + wordCountInputStreamReader + " | Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to count words using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
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
                wordCount += new StringTokenizer(line).countTokens();
            }

        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
