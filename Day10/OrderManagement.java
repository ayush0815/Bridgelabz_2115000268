import java.time.LocalDate; // Use LocalDate for dates

class Order {
    int orderId;
    LocalDate orderDate;

    public Order(int orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + "]";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(int orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped";
    }

    @Override
    public String toString() {
        return "ShippedOrder [" + super.toString() + ", trackingNumber=" + trackingNumber + "]";
    }
}

class DeliveredOrder extends ShippedOrder {
    LocalDate deliveryDate;

    public DeliveredOrder(int orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered";
    }

    @Override
    public String toString() {
        return "DeliveredOrder [" + super.toString() + ", deliveryDate=" + deliveryDate + "]";
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        Order order = new Order(1, LocalDate.now());
        ShippedOrder shippedOrder = new ShippedOrder(2, LocalDate.now(), "ABC123XYZ");
        DeliveredOrder deliveredOrder = new DeliveredOrder(3, LocalDate.now(), "PQR456UVW", LocalDate.now().plusDays(5));

        System.out.println(order);
        System.out.println("Status: " + order.getOrderStatus());
        System.out.println("---");

        System.out.println(shippedOrder);
        System.out.println("Status: " + shippedOrder.getOrderStatus());
        System.out.println("---");

        System.out.println(deliveredOrder);
        System.out.println("Status: " + deliveredOrder.getOrderStatus());
    }
}