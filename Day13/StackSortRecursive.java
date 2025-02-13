import java.util.Stack;
class StackSortRecursive {
    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            //1. Remove the top element
            int top = stack.pop();
            //2. Sort the remaining stack
            sortStack(stack);
            //3. Insert the top element back in sorted order
            insertSorted(stack, top);
        }
    }
    // Helper function to insert an element into the sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case, If stack is empty or top element is smaller, push element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
    // Otherwise, pop the top element and recurse
        int top = stack.pop();
        insertSorted(stack, element);
    // Push the top element back after inserting
        stack.push(top);
    }
    // Print Stack
    public static void printStack(Stack<Integer> stack) {
        for (int num : stack) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}
