package RealLife;
import java.util.*;
public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedByPrice = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        sortedByPrice.put(price, product);
    }

    public void addToCart(String product) {
        if (!productPrices.containsKey(product)) return;
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }

    public void displayCart() {
        System.out.println("Cart Items: " + cart);
        System.out.println("Sorted by Price: " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 70000);
        cart.addProduct("Phone", 15000);
        cart.addToCart("Laptop");
        cart.addToCart("Phone");
        
        cart.displayCart();
    }
}
