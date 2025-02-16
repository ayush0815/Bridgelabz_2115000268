public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        String text = "hello";

        // Measure time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        // Measure time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbl.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        // Print results
        System.out.println("Time taken by StringBuffer: " + durationBuffer / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + durationBuilder / 1_000_000 + " ms");

        // Comparison
        if (durationBuffer > durationBuilder) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }
    }
}
