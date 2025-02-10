// Interface for tax-related operations
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class representing a Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setter for price (encapsulation)
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    // Abstract method for discount calculation
    public abstract double calculateDiscount();

    // Display product details
    public void displayDetails() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Concrete class for Electronics (implements Taxable)
class Electronics extends Product implements Taxable {
    private static final double DISCOUNT_RATE = 0.10; // 10% discount
    private static final double TAX_RATE = 0.18; // 18% tax

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Implementing abstract method
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    // Implementing Taxable methods
    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 18%";
    }
}

// Concrete class for Clothing (implements Taxable)
class Clothing extends Product implements Taxable {
    private static final double DISCOUNT_RATE = 0.15; // 15% discount
    private static final double TAX_RATE = 0.05; // 5% tax

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Implementing abstract method
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    // Implementing Taxable methods
    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 5%";
    }
}

// Concrete class for Groceries (no tax applicable)
class Groceries extends Product {
    private static final double DISCOUNT_RATE = 0.05; // 5% discount

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Implementing abstract method
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }
}

class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 60000);
        Product p2 = new Clothing(102, "T-Shirt", 1200);
        Product p3 = new Groceries(103, "Wheat Flour", 750);

        // Storing products in an array
        Product[] products = {p1, p2, p3};

        // Processing products using polymorphism
        for (Product product : products) {
            product.displayDetails();
            double discount = product.calculateDiscount();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);

            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println();
        }
    }
}
