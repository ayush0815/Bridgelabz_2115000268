public class PeakElementBS {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // Peak is in the left half
                right = mid;
            } else {
                // Peak is in the right half
                left = mid + 1;
            }
        }
        return left; // 'left' will be at the peak element index
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(arr);

        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element: " + arr[peakIndex]);
    }
}
