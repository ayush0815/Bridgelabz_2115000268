import java.io.*;
public class ImageByteArray {
    public static void main(String[] args) {
        String inputImage = "input.jpg";
        String outputImage = "output.jpg";

        try (FileInputStream fis = new FileInputStream(inputImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            // Read image into byte array
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();
            // Write byte array back to a new image file
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(outputImage)) {

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Image successfully copied");

            }

        } catch (IOException e) {
            System.out.println("Error handling image" + e.getMessage());
        }
    }
}
