class Book {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // Book is available by default
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book '" + title + "' is currently unavailable.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("You have returned: " + title);
    }

    public void displayBook() {
        System.out.println("\nTitle: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 12.99);
        Book book2 = new Book("1984", "George Orwell", 10.50);
        book1.displayBook();
        book2.displayBook();

        book1.borrowBook();  
        book1.borrowBook();  // Try to borrow again (should be unavailable)
        book1.returnBook();  // Return "The Alchemist"
        book1.borrowBook();  // Borrow again

        book1.displayBook();
        book2.displayBook();
    }
}
