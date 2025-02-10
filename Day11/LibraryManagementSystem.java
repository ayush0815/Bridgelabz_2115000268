// Interface for reservation-related operations
interface Reservable {
    boolean reserveItem(String user);
    boolean checkAvailability();
}

// Abstract class representing a library item
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true; // Default to available

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to update availability
    protected void setAvailability(boolean status) {
        this.isAvailable = status;
    }

    // Abstract method to get loan duration (must be implemented in subclasses)
    public abstract int getLoanDuration();

    // Concrete method to get item details
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
}

// Concrete class for Book
class Book extends LibraryItem implements Reservable {
    private static final int LOAN_DAYS = 14; // Books have a loan period of 14 days

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DAYS;
    }

    // Implementing Reservable methods
    @Override
    public boolean reserveItem(String user) {
        if (isAvailable()) {
            setAvailability(false);
            System.out.println(user + " reserved the book: " + getTitle());
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Concrete class for Magazine
class Magazine extends LibraryItem {
    private static final int LOAN_DAYS = 7; // Magazines have a loan period of 7 days

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DAYS;
    }
}

// Concrete class for DVD
class DVD extends LibraryItem implements Reservable {
    private static final int LOAN_DAYS = 5; // DVDs have a loan period of 5 days

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DAYS;
    }

    // Implementing Reservable methods
    @Override
    public boolean reserveItem(String user) {
        if (isAvailable()) {
            setAvailability(false);
            System.out.println(user + " reserved the DVD: " + getTitle());
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem book1 = new Book("B101", "Kitne Gazi aaye Kitne Gazi gaye", "Lt Gen KJS Dhillon");
        LibraryItem magazine1 = new Magazine("M201", "National Geographic", "Editorial Team");
        LibraryItem dvd1 = new DVD("D301", "Interstellar", "Christopher Nolan");

        // Storing items in an array
        LibraryItem[] items = {book1, magazine1, dvd1};

        // Processing items using polymorphism
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Handling reservations for reservable items
            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Available for reservation: " + reservable.checkAvailability());
                reservable.reserveItem("Ayush");
            }

            System.out.println();
        }
    }
}
