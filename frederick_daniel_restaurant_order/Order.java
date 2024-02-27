package frederick_daniel_restaurant_order;

public class Order {
    private int id; // Unquie identifier from each order
    private String details; // What a customer ordered

    // Constructor
    public Order(int id, String details) {
        this.id = id; // Give value to an order id
        this.details = details; // Give value to order details
    }

    // Override toString method to easily display an order in queue and stack classes
    public String toString() {
        return "Order ID: " + id + ", Details: " + details;
    }

}
