class Book{
    static String libraryName = "Gyan Bhandar";
    private String title;
    private String author;
    final private int isbn;

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isbn = (int)(Math.random() * Math.pow(10,100));
    }

    static void displayLibraryName(){
        System.out.println("\nLibrary Name is: " + libraryName);
    }

    void display(){
        System.out.println("\nTitle of the book is: " + title);
        System.out.println("Author of the book is: " + author);
        System.out.println("Identification number is: " + isbn);
    }

    public static void main(String[] args){
        Book book1 = new Book("India's Bravehearts","Lt Gen Satish Dua");
        if(book1 instanceof Book){
            System.out.println("book1 is instance of Book class");
            book1.display();
        }
        book1.displayLibraryName();
    }
}
