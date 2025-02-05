import java.util.ArrayList;
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("India's Most Fearless", "Shiv Arror");
        Book book2 = new Book("Kitne Gazi Aaye Kitne Gazi Gaye", "Lt Gen KJS Dhillon");

        library.addBook(book1);
        library.addBook(book2);
        library.displayBooks();

        // Book can exist independently
        Book book3 = new Book("Internal Security", "Pavneet Singh"); 

        Library anotherLibrary = new Library();
        anotherLibrary.addBook(book3);
        anotherLibrary.displayBooks();
    }
}