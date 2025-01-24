package Day3.Level1;

import java.util.Scanner;

public class Array2DTo1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows and columns for the matrix:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] oneDArray = new int[rows * cols];
        int index = 0;

        System.out.println("Enter elements for the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                oneDArray[index++] = matrix[i][j];
            }
        }

        System.out.println("1D Array:");
        for (int val : oneDArray) System.out.print(val + " ");
        sc.close();
    }
}

