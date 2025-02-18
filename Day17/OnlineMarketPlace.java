import java.util.ArrayList;
import java.util.List;
// Define category enums
enum BookCategory {
    Fiction, Non_Fiction, Science, History
}
enum ClothingCategory {
    Men, Women, Kids
}
enum GadgetCategory {
    Mobile, Laptop, Accesorry
}
// Generic Product Class with Bounded Type Parameter
abstract class Product<T> {
    private String name;
    private double price;
    private T category;  // Category type (BookCategory, ClothingCategory, etc.)

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - Rs" + price;
    }
}
// Concrete Product Classes for Different Categories
class Book extends Product<BookCategory> {
    public Book(String name, double price, BookCategory category) {
        super(name, price, category);
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price, category);
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price, category);
    }
}
// Generic Marketplace Class to Handle Products
class ProductCatalog {
    private List<Product<?>> products;  // Allows multiple product types

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("Product Catalog:");
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

// Utility Class with Generic Discount Method
class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
        System.out.println("Discount applied to " + product.getName() + "! New price: Rs" + String.format("%.2f", newPrice));
    }
}

public class OnlineMarketPlace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        // Adding Books
        Book book1 = new Book("The Kite Runner", 500.0, BookCategory.Fiction);
        Book book2 = new Book("India's Wars", 865.0, BookCategory.History);

        // Adding Clothing
        Clothing clothing1 = new Clothing("Men's Jacket", 4999.0, ClothingCategory.Men);
        Clothing clothing2 = new Clothing("Women's Dress", 3999.0, ClothingCategory.Women);

        // Adding Gadgets
        Gadget gadget1 = new Gadget("Smartphone", 29999.0, GadgetCategory.Mobile);
        Gadget gadget2 = new Gadget("Laptop", 74999.0, GadgetCategory.Laptop);

        // Adding products to catalog
        catalog.addProduct(book1);
        catalog.addProduct(book2);
        catalog.addProduct(clothing1);
        catalog.addProduct(clothing2);
        catalog.addProduct(gadget1);
        catalog.addProduct(gadget2);

        // Display products
        catalog.displayProducts();

        // Apply Discounts
        System.out.println("\nApplying Discounts:");
        DiscountUtil.applyDiscount(book1, 20);  // 20% discount
        DiscountUtil.applyDiscount(clothing2, 20);  // 20% discount
        DiscountUtil.applyDiscount(gadget1, 15);  // 15% discount

        // Display updated products
        System.out.println("\nUpdated Product Catalog:");
        catalog.displayProducts();
    }
}
