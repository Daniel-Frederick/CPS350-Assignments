package frederick_daniel_restaurant_order;

public class RestaurantManagement {
    
    public static void main(String[] args) {

        // Create queue
        ArrayQueue orderQueue = new ArrayQueue(10);

        // Create stack
        OrderStack orderStack = new OrderStack(10);

        // Creating orders
        Order order1 = new Order(1, "Burger and Fries");
        Order order2 = new Order(2, "Pizza");

        // Adding orders
        orderQueue.enqueue(order1); // Add order1
        orderQueue.enqueue(order2); // Add order2

        System.out.println(); // Spacing

        // Processing orders
        orderQueue.dequeue(); // Remove from queue to process order1
        orderStack.push(order1); // Add order1 to stack

        System.out.println(); // Spacing

        orderQueue.dequeue(); // Remove from queue to process order2
        orderStack.push(order2); // Add order2 to stack

        System.out.println(); // Spacing

        // Reviewing last processed order
        orderStack.peek(); // Review the last order added in stack

        System.out.println(); // Spacing

        // Undoing last processed order
        orderStack.pop(); // Remove the last order in stack

        System.out.println(); // Spacing

        // Reviewing Last Processed Order (after undo)...
        orderStack.peek(); // Review the new top order in stack

    }

}
