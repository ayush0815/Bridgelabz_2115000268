import java.util.Arrays;
public class NumberCheckerTwo {
    public static void main(String[] args) {
        int number = 1221;
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);
        int[] digitsArray = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digitsArray));
        int[] reversedArray = reverseDigitsArray(digitsArray);
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));
        boolean areArraysEqual = compareArrays(digitsArray, reversedArray);
        System.out.println("Are digits and reversed arrays equal: " + areArraysEqual);
        boolean isPalindrome = isPalindrome(digitsArray);
        System.out.println("Is Palindrome: " + isPalindrome);
        boolean isDuckNumber = isDuckNumber(digitsArray);
        System.out.println("Is Duck Number: " + isDuckNumber);
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
    public static int[] reverseDigitsArray(int[] digits) {
        int length = digits.length;
        int[] reversed = new int[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = digits[length - 1 - i];
        }
        return reversed;
    }
    public static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigitsArray(digits);
        return compareArrays(digits, reversed);
    }
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
