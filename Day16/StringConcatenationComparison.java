public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000}; // Different dataset sizes

        for (int N : sizes) {
            System.out.println("Operations Count (N): " + N);

            // Measure time for String concatenation (O(N²))
            long startTime = System.nanoTime();
            String str = " ";
            for (int i = 0; i < N; i++) {
                str += "a"; // Creates a new object each time
            }
            long stringTime = System.nanoTime() - startTime;
            System.out.println("String (O(N²)) Time: " + (stringTime / 1_000_000.0) + " ms");

            // Measure time for StringBuilder concatenation (O(N))
            startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append("a");
            }
            long stringBuilderTime = System.nanoTime() - startTime;
            System.out.println("StringBuilder (O(N)) Time: " + (stringBuilderTime / 1_000_000.0) + " ms");

            // Measure time for StringBuffer concatenation (O(N))
            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sbf.append("a");
            }
            long stringBufferTime = System.nanoTime() - startTime;
            System.out.println("StringBuffer (O(N)) Time: " + (stringBufferTime / 1_000_000.0) + " ms");
        }
    }
}
