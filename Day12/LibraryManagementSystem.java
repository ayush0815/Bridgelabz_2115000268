class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}
// Library Management System using Doubly Linked List
class Library {
    private Book head, tail;
    private int count = 0; // To track total books
    // Add book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }
    // Add book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }
    // Add book at a specific position
    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int index = 1;
        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }
        if (temp == null) {
            System.out.println("Position out of range, adding at the end.");
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newBook;
            } else {
                tail = newBook; // Updating tail if added at the end
            }
            temp.next = newBook;
            count++;
        }
    }
    // Remove a book by Book ID
    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        Book temp = head;
    // If head is the book to be deleted
        if (temp != null && temp.bookId == bookId) {
            head = temp.next;
            if (head != null) head.prev = null;
            else tail = null; // If only one book existed
            count--;
            System.out.println("Book removed successfully.");
            return;
        }
        // Search for the book to be deleted
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found!");
            return;
        }
        // Remove book from list
        temp.prev.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev; // Updating tail if last book is removed
        }
        count--;
        System.out.println("Book removed successfully.");
    }
        // Search for a book by Title or Author
    public void searchBook(String searchValue) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(searchValue) || temp.author.equalsIgnoreCase(searchValue)) {
                System.out.println("Book Found: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | ID: " + temp.bookId + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }
    // Update a book’s Availability Status
    public void updateAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Book availability updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }
    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        System.out.println("Library Books (Forward Order):");
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.next;
        }
    }
    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty!");
            return;
        }
        System.out.println("Library Books (Reverse Order):");
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.prev;
        }
    }
    // Count total number of books in the library
    public void countBooks() {
        System.out.println("Total Books in Library: " + count);
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addAtBeginning("The Braves", "Lt Gen Satish Dua", "Biography", 101, true);
        library.addAtEnd("Khalistan Conspiracy", "KJS Sandhu", "History", 102, true);
        library.addAtEnd("The Indian Pilgrimage", "Subhash Chandra Bose", "Heritage", 103, false);
        library.addAtEnd("Pride and Prejudice", "Jane Austen", "Romance", 104, true);
        library.addAtEnd("You Are Unique", "Dr. APJ Abdul Kalam", "Self help", 105, true);

        // Display books 
        library.displayBooksForward();
        library.displayBooksReverse();
        library.searchBook("You Are Unique");
        library.updateAvailability(103, true);
        library.removeBook(104);
        library.displayBooksForward();
        library.countBooks();
    }
}
