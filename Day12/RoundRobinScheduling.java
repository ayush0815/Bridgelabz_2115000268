import java.util.Scanner;
// Node representing a Process in the Circular Linked List
class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
// Circular Linked List for Round Robin Scheduling
class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int totalProcesses = 0;
    // Add a process at the end of the circular linked list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head; // Circular link
            tail = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head; // Circular link
            tail = newProcess;
        }
        totalProcesses++;
    }
    // Remove a process after execution
    private void removeProcess(Process prev, Process toRemove) {
        if (toRemove == head && toRemove == tail) {
            head = tail = null;
        } else if (toRemove == head) {
            tail.next = head.next;
            head = head.next;
        } else if (toRemove == tail) {
            prev.next = head;
            tail = prev;
        } else {
            prev.next = toRemove.next;
        }
        totalProcesses--;
    }
    // Simulate Round Robin scheduling
    public void executeProcesses(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int currentTime = 0;
        Process current = head;
        Process prev = tail; // Track previous node for removal

        System.out.println("\nExecuting processes with time quantum = " + timeQuantum);

        while (totalProcesses > 0) {
            if (current.remainingTime > 0) {
                System.out.println("\nExecuting Process ID: " + current.processId + " | Remaining Time: " + current.remainingTime);
                
                // Execute the process for the time quantum or remaining burst time
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executionTime;
                currentTime += executionTime;

                if (current.remainingTime == 0) {
                    // Process completed, calculate turnaround and waiting time
                    int turnaroundTime = currentTime;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalWaitingTime += waitingTime;

                    System.out.println("Process " + current.processId + " completed! Turnaround Time: " + turnaroundTime + ", Waiting Time: " + waitingTime);
                    removeProcess(prev, current); // Remove completed process
                } else {
                    prev = current;
                }
            }
            current = current.next; // Move to the next process in the circular list
        }

        // Calculate and display average waiting and turnaround time
        double avgWaitingTime = (double) totalWaitingTime / (totalProcesses + 1);
        double avgTurnaroundTime = (double) totalTurnaroundTime / (totalProcesses + 1);

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    // Display the process queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("\nCurrent Process Queue:");
        do {
            System.out.println("Process ID: " + temp.processId + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}
public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 12, 2);
        scheduler.addProcess(5, 6, 1);

        // Display the process queue
        scheduler.displayProcesses();

        // Execute processes using Round Robin Scheduling
        System.out.print("\nEnter time quantum: ");
        int timeQuantum = scanner.nextInt();
        scheduler.executeProcesses(timeQuantum);
        
        scanner.close();
    }
}
