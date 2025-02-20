package Queue;
import java.util.*;
class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        q1.add(x);
    }
    // Pop operation
    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int topElement = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return topElement;
    }
    // Top operation
    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int topElement = q1.peek();
        q2.add(q1.poll());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return topElement;
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();

        // Operations
        System.out.println("Enter number of operations:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter operation (push/pop/top): ");
            String op = sc.next();
            if (op.equals("push")) {
                System.out.print("Enter value to push: ");
                int val = sc.nextInt();
                stack.push(val);
            } else if (op.equals("pop")) {
                System.out.println("Popped: " + stack.pop());
            } else if (op.equals("top")) {
                System.out.println("Top element: " + stack.top());
            }
        }
        sc.close();
    }
}

