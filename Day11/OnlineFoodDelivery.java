// Interface for applying discounts
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class representing a food item
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Method to update quantity safely (Encapsulation)
    public void updateQuantity(int newQuantity) {
        if (newQuantity > 0) {
            this.quantity = newQuantity;
        } else {
            System.out.println("Invalid quantity update. Quantity should be greater than 0.");
        }
    }

    // Abstract method to calculate the total price (implemented in subclasses)
    public abstract double calculateTotalPrice();

    // Concrete method to get item details
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: Rs" + price + ", Quantity: " + quantity);
    }
}

// Concrete class for VegItem
class VegItem extends FoodItem implements Discountable {
    private static final double DISCOUNT = 0.05; // 5% discount for Veg items

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * DISCOUNT;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 5%";
    }
}

// Concrete class for NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_EXTRA_CHARGE = 20.0; // Extra charge for non-veg items
    private static final double DISCOUNT = 0.03; // 3% discount for Non-Veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_EXTRA_CHARGE;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * DISCOUNT;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 3% (Extra Rs20 charge applied)";
    }
}

class OnlineFoodDelivery {
    public static void processOrder(FoodItem[] orderItems) {
        System.out.println("\n--- Order Summary ---");
        double grandTotal = 0;

        for (FoodItem item : orderItems) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price (before discount): Rs" + totalPrice);

            // Check if item is discountable
            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                double discount = discountable.applyDiscount();
                System.out.println(discountable.getDiscountDetails());
                totalPrice -= discount;
                System.out.println("Discount Applied: -Rs" + discount);
            }

            System.out.println("Final Price: Rs" + totalPrice + "\n");
            grandTotal += totalPrice;
        }

        System.out.println("Grand Total: Rs" + grandTotal);
    }

    public static void main(String[] args) {
        FoodItem pizza = new VegItem("Margherita Pizza", 250, 2);
        FoodItem burger = new VegItem("Cheese Burger", 150, 1);
        FoodItem pasta = new VegItem("White Sauce Pasta", 180, 1);
        FoodItem biryani = new NonVegItem("Chicken Biryani", 350, 2);

        // Storing items in an order array
        FoodItem[] orderItems = {pizza, burger, pasta, biryani};

        // Processing the order
        processOrder(orderItems);
    }
}
