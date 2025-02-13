import java.util.Stack;
class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Result array
        Stack<Integer> stack = new Stack<>(); // Stack stores indices
        for (int i = 0; i < n; i++) {
            // Pop elements while stack is not empty and top element is ≤ current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, span is i + 1 (all previous prices were smaller)
            // Otherwise, span is difference between current index and top of stack
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index onto stack
            stack.push(i);
        }
        
        return span;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);

        System.out.println("Stock Prices:");
        printArray(prices);
        
        System.out.println("Stock Spans:");
        printArray(spans);
    }
}
