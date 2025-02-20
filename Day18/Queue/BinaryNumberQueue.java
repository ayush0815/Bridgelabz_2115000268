package Queue;
import java.util.*;
public class BinaryNumberQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of binary numbers to generate
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.println("First " + n + " binary numbers:");
        for (int i = 0; i < n; i++) {
            String curr = queue.poll();
            System.out.print(curr + " ");
            queue.add(curr + "0");
            queue.add(curr + "1");
        }
        sc.close();
    }
}
