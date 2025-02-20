package Queue;
import java.util.*;
class CircularBuffer {
    int[] buffer;
    int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insert(int value) {
        rear = (rear + 1) % size;
        buffer[rear] = value;
        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // Overwrite oldest element
        }
    }

    public void display() {
        if (count == 0) {
            System.out.println("Buffer is empty");
            return;
        }
        System.out.print("Buffer: ");
        int index = front;
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[index] + " ");
            index = (index + 1) % size;
        }
        System.out.println();
    }
}

class CircularBufferExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter buffer size");
        int size = sc.nextInt();
        CircularBuffer cb = new CircularBuffer(size);

        // Input number of elements
        System.out.print("Enter number of elements to insert");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            cb.insert(sc.nextInt());
            cb.display();
        }
    sc.close();
    }
}
