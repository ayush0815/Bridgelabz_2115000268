import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatting {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        String formattedDate1 = today.format(formatter1);
        String formattedDate2 = today.format(formatter2);
        String formattedDate3 = today.format(formatter3);

        System.out.println("Format 1: " + formattedDate1);
        System.out.println("Format 2: " + formattedDate2);
        System.out.println("Format 3: " + formattedDate3);
    }
}