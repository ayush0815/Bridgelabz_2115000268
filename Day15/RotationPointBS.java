public class RotationPointBS {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the last element, rotation point is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // If mid element is smaller, rotation point is in the left half (including mid)
                right = mid;
            }
        }
        return left; // The smallest element's index
    }

    public static void main(String[] args) {
        int[] rotatedArray = { 6, 7, 9, 15, 19, 2, 3 };
        int rotationIndex = findRotationPoint(rotatedArray);

        System.out.println("Rotation Point Index: " + rotationIndex);
        System.out.println("Smallest Element: " + rotatedArray[rotationIndex]);
    }
}
