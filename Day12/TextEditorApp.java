import java.util.Scanner;
// Node representing a state in the text editor
class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
// Doubly Linked List for Undo/Redo Functionality
class TextEditor {
    private TextState head, current;
    private int maxHistory = 10; // Limit history to last 10 states
    private int stateCount = 0;

    public TextEditor() {
        head = new TextState(""); // Initial empty state
        current = head;
        stateCount = 1;
    }
    // Add a new text state (New action performed)
    public void addState(String newContent) {
        TextState newState = new TextState(newContent);

        // Remove all redo states (next states)
        current.next = null;

        // Set new state as current
        newState.prev = current;
        current.next = newState;
        current = newState;
        stateCount++;

        // Maintain history limit
        if (stateCount > maxHistory) {
            head = head.next; // Remove oldest state
            head.prev = null;
            stateCount--;
        }
    }

    // Undo functionality (Move to previous state)
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo functionality (Move to next state)
    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        System.out.println("Current Text: \"" + current.content + "\"");
    }
}
public class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\nOptions: \n1. Type new text \n2. Undo \n3. Redo \n4. Display Text \n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = scanner.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting text editor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
