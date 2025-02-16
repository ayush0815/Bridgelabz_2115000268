import java.io.*;
public class IpStreamReader {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your file path
        String charset = "UTF-8"; // Specify the encoding

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, charset);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
