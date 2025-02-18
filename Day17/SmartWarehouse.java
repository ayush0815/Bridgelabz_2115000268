import java.util.ArrayList;
import java.util.List;

// Abstract class for warehouse items
abstract class WarehouseItem {
    private String name;
    
    public WarehouseItem(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}

// Subclasses for different item categories
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

// Generic class for storing warehouse items
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
    
    public void displayItems() {
        System.out.println("Storage Items:");
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Utility class to display items from any storage type
class WarehouseUtil {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("Displaying all warehouse items:");
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("TV"));
        
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Bread"));
        groceriesStorage.addItem(new Groceries("Milk"));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Couch"));

        // Using wildcard method to display all items
        System.out.println("\nUsing Wildcard Method:");
        WarehouseUtil.displayAllItems(electronicsStorage.getItems());
        WarehouseUtil.displayAllItems(groceriesStorage.getItems());
        WarehouseUtil.displayAllItems(furnitureStorage.getItems());
    }
}
