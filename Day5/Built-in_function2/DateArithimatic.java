import java.time.LocalDate;
public class DateArithimatic {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Add 7 days, 1 month, and 2 years
        LocalDate modifiedDate = today.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks
        modifiedDate = modifiedDate.minusWeeks(3);

        System.out.println("Modified Date: " + modifiedDate);
    }
}