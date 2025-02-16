public class Search2DSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D indices

            if (midElement == target) {
                return true; // Target found
            } else if (midElement < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return false; // Target not found
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        
        int target = 3;
        System.out.println("Target " + target + " found: " + searchMatrix(matrix, target));

        target = 13;
        System.out.println("Target " + target + " found: " + searchMatrix(matrix, target));
    }
}
