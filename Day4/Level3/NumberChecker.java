import java.util.Arrays;
public class NumberChecker {
  public static void main(String[] args) {
    int number = 153;
    int digitCount = countDigits(number);
    System.out.println(digitCount);
    int[] digitsArray = getDigitsArray(number);
    System.out.println(Arrays.toString(digitsArray));
    boolean isDuck = isDuckNumber(digitsArray);
    System.out.println(isDuck);
    boolean isArmstrong = isArmstrongNumber(number);
    System.out.println(isArmstrong);
    int[] largestNumbers = findLargestAndSecondLargest(digitsArray);
    System.out.println(largestNumbers[0]);
    System.out.println(largestNumbers[1]);
    int[] smallestNumbers = findSmallestAndSecondSmallest(digitsArray);
    System.out.println(smallestNumbers[0]);
    System.out.println(smallestNumbers[1]);
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
  public static boolean isDuckNumber(int[] digits) {
    for (int i = 1; i < digits.length; i++) {
      if (digits[i] == 0) {
        return true;
      }
    }
    return false;
  }
  public static boolean isArmstrongNumber(int number) {
    int[] digits = getDigitsArray(number);
    int power = digits.length;
    int sum = 0;
    for (int digit : digits) {
      sum += Math.pow(digit, power);
    }
    return sum == number;
  }
  public static int[] findLargestAndSecondLargest(int[] digits) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    for (int digit : digits) {
      if (digit > largest) {
        secondLargest = largest;
        largest = digit;
      } else if (digit > secondLargest && digit != largest) {
        secondLargest = digit;
      }
    }
    return new int[] { largest, secondLargest };
  }
  public static int[] findSmallestAndSecondSmallest(int[] digits) {
    int smallest = Integer.MAX_VALUE;
    int secondSmallest = Integer.MAX_VALUE;
    for (int digit : digits) {
      if (digit < smallest) {
        secondSmallest = smallest;
        smallest = digit;
      } else if (digit < secondSmallest && digit != smallest) {
        secondSmallest = digit;
      }
    }

    return new int[] { smallest, secondSmallest };
  }
}
