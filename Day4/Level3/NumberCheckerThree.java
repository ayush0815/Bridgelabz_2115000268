public class NumberCheckerThree {
    public static void main(String[] args) {
        int number = 25;
        System.out.println("Number: " + number);
        System.out.println("Is Prime Number: " + isPrimeNumber(number));
        System.out.println("Is Neon Number: " + isNeonNumber(number));
        System.out.println("Is Spy Number: " + isSpyNumber(number));
        System.out.println("Is Automorphic Number: " + isAutomorphicNumber(number));
        System.out.println("Is Buzz Number: " + isBuzzNumber(number));
    }
    public static boolean isPrimeNumber(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        while (square != 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }
    public static boolean isSpyNumber(int number) {
        int sum = 0, product = 1;
        while (number != 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}
