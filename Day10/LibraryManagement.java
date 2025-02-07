class Book {
    String title;
    int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", publicationYear=" + publicationYear + "]";
    }
}

class Author extends Book {  // Author IS-A Book (Single Inheritance)
    String name;
    String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); // Call superclass constructor
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }

    @Override
    public String toString() {
        return "Author [" + super.toString() + ", name=" + name + ", bio=" + bio + "]";
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author author = new Author("Bipin", 2020, "Rachna Bisht Rawat", "Army Brat and Army Wife");
        System.out.println(author); // Uses the overridden toString()
        author.displayInfo();


        Book book = new Book("Rambo", 2024); // Illustrates that you can still create just a Book object
        System.out.println(book);
    }
}