import java.util.ArrayList;
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (Price: Rs" + price + ")";
    }
}

class Order {
    Customer customer; // Association
    ArrayList<Product> products; // Aggregation

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    public void displayOrderDetails() {
      System.out.println("Order for: " + customer.name);
      System.out.println("Products:");
      for (Product product : products) {
        System.out.println(product);
      }
      System.out.println("Total: Rs" + calculateTotal());
    }
}

class Customer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    public Order placeOrder() {
        return new Order(this);
    }

    @Override
    public String toString() {
        return "Customer: " + name;
    }
}

public class EcommerceDemo {
    public static void main(String[] args) {
        Customer ayush = new Customer("Ayush");
        Product phone = new Product("Smartphone", 19999.00);
        Product laptop = new Product("Laptop", 59999.00);

        Order order = ayush.placeOrder();
        order.addProduct(phone);
        order.addProduct(laptop);

        order.displayOrderDetails();

    }
}