import java.util.Arrays;
public class NumberCheckerOne {
    public static void main(String[] args) {
        int number = 21;
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);
        int[] digitsArray = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digitsArray));
        int sumOfDigits = findSumOfDigits(digitsArray);
        System.out.println("Sum of digits: " + sumOfDigits);
        int sumOfSquares = findSumOfSquares(digitsArray);
        System.out.println("Sum of squares of digits: " + sumOfSquares);
        boolean isHarshad = isHarshadNumber(number, sumOfDigits);
        System.out.println("Is Harshad Number: " + isHarshad);
        int[][] digitFrequency = findDigitFrequency(digitsArray);
        System.out.println("Digit Frequencies:");
        for (int[] freq : digitFrequency) {
            System.out.println("Digit: " + freq[0] + ", Frequency: " + freq[1]);
        }
    }
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    public static int[] getDigitsArray(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        int index = digitCount - 1;
        while (number != 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }
    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    public static int findSumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
    public static boolean isHarshadNumber(int number, int sumOfDigits) {
        return number % sumOfDigits == 0;
    }
    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return Arrays.stream(frequency).filter(freq -> freq[1] > 0).toArray(int[][]::new);
    }
}
