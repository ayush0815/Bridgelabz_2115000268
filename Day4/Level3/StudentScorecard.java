import java.util.Random;
import java.util.Scanner;
public class StudentScorecard {
    public static int[][] generateStudentScores(int numStudents) {
        Random random = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 40 + random.nextInt(61);
            scores[i][1] = 40 + random.nextInt(61);
            scores[i][2] = 40 + random.nextInt(61);
        }
        return scores;
    }
    public static String[][] calculateScorecard(int[][] scores) {
        String[][] scorecard = new String[scores.length][5];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            String grade;
            if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B";
            else if (percentage >= 60) grade = "C";
            else if (percentage >= 50) grade = "D";
            else if (percentage >= 40) grade = "E";
            else grade = "R";
            scorecard[i][0] = String.valueOf(total);
            scorecard[i][1] = String.format("%.2f", average);
            scorecard[i][2] = String.format("%.2f", percentage);
            scorecard[i][3] = grade;
        }
        return scorecard;
    }
    public static void displayScorecard(int[][] scores, String[][] scorecard) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-7d%-9d%-12d%-7d%-6s%-8s%-13s%s\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    scorecard[i][0], scorecard[i][1], scorecard[i][2], scorecard[i][3]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        int[][] scores = generateStudentScores(numStudents);
        String[][] scorecard = calculateScorecard(scores);
        displayScorecard(scores, scorecard);
        scanner.close();
    }
}
