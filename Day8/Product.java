class Product {
    static double discount = 10.0; // Shared discount for all products
    final private int productID; // Unique identifier that cannot be changed
    private String productName;
    private double price;
    private int quantity;


    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to display product details
    void display() {
        System.out.println("\nProduct ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: Rs" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {
        Product product1 = new Product(2115, "Headphones", 1500.0, 4);
        Product product2 = new Product(1002, "Type c charger", 800.0, 5);

        // Checking instanceof before processing
        if (product1 instanceof Product) {
            System.out.println("\nproduct1 is an instance of Product class");
            product1.display();
        }

        if (product2 instanceof Product) {
            System.out.println("\nproduct2 is an instance of Product class");
            product2.display();
        }

        // Updating discount
        Product.updateDiscount(15.0);
        System.out.println("\nUpdated Discount for all products: " + Product.discount + "%");
    }
}
