package Day2.Level1_PP;
//o find the sum of n natural numbers using for loop 
//compare the result with the formulae n*(n+1)/2 and show 
//the result from both computations was correct. 

import java.util.Scanner;

public class SumOfnNumsFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n > 0) {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using for loop: " + sumLoop);
            System.out.println("Results match: " + (sumFormula == sumLoop));
        } else {
            System.out.println("The number is not a natural number.");
        }
        scanner.close();
    }
}

