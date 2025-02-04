// Superclass Book
public class Book {
    // Public ISBN field
    public String ISBN;

    // Protected title field
    protected String title;

    // Private author field
    private String author;

    // Constructor for the Book class
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Method to set the author's name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to get the author's name
    public String getAuthor() {
        return this.author;
    }
}

// Subclass EBook
class EBook extends Book {

    // Constructor for EBook class
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author); // Call the constructor of the parent class
    }

    // Method to access ISBN and title from the parent class
    public void displayInfo() {
        System.out.println("ISBN: " + ISBN); // ISBN is public, so accessible
        System.out.println("Title: " + title); // Title is protected, so accessible in subclass
        // System.out.println("Author: " + author); // Cannot access 'author' directly, it's private in the parent class
    }

    public static void main(String[] args) {
        // Create an instance of EBook
        EBook myEBook = new EBook("26071999", "Who Cares Wins", "Lt Gen YK Joshi");

        // Display ISBN and title
        myEBook.displayInfo();

        // Access and modify the author's name using the getter and setter methods
        System.out.println("Author (via getter): " + myEBook.getAuthor());
        myEBook.setAuthor("Lt Gen YK 'Joe' Joshi");
        System.out.println("Updated Author (via getter): " + myEBook.getAuthor());
    }
}


