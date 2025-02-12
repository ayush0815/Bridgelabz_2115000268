// Node class representing an inventory item
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
// Inventory Management System using Singly Linked List
class Inventory {
    private Item head;

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }
    // Add item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }
    // Add item at a specific position
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 1) {
            newItem.next = head;
            head = newItem;
            return;
        }
        Item temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position out of range, adding at the end.");
            addAtEnd(itemName, itemId, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }
    // Remove an item by Item ID
    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item not found!");
            return;
        }
        prev.next = temp.next;
        System.out.println("Item removed successfully.");
    }
    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }
    // Search for an item by ID or Name
    public void searchItem(String searchValue) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(searchValue) || temp.itemName.equalsIgnoreCase(searchValue)) {
                System.out.println("Item Found: " + temp.itemName + " | ID: " + temp.itemId + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found!");
        }
    }
    // Calculate and display total inventory value
    public void totalInventoryValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }
    // Display all items
    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        System.out.println("Inventory Items:");
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + " | Name: " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }

    // Sort inventory based on Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort.");
            return;
        }
        head = mergeSort(head, criteria, ascending);
        System.out.println("Inventory sorted successfully.");
    }

    // Merge sort implementation for linked list sorting
    private Item mergeSort(Item head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria, ascending);
        Item right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    // Function to find the middle of the linked list
    private Item getMiddle(Item head) {
        if (head == null) {
            return head;
        }
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merging two sorted linked lists based on criteria
    private Item sortedMerge(Item left, Item right, String criteria, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        boolean condition;
        if (criteria.equalsIgnoreCase("name")) {
            condition = ascending ? left.itemName.compareTo(right.itemName) < 0 : left.itemName.compareTo(right.itemName) > 0;
        } else {
            condition = ascending ? left.price < right.price : left.price > right.price;
        }

        if (condition) {
            result = left;
            result.next = sortedMerge(left.next, right, criteria, ascending);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next, criteria, ascending);
        }
        return result;
    }
}
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addAtBeginning("Laptop", 101, 5, 45000.0);
        inventory.addAtEnd("Smartphone", 102, 10, 20000.0);
        inventory.addAtEnd("Headphones", 103, 15, 1500.0);
        inventory.addAtEnd("Monitor", 104, 7, 12000.0);
        inventory.addAtEnd("Keyboard", 105, 20, 800.0);

        // Display items
        inventory.displayItems();

        // Sort and display
        inventory.sortInventory("price", true);
        inventory.displayItems();

        // Display total inventory value
        inventory.totalInventoryValue();
    }
}
