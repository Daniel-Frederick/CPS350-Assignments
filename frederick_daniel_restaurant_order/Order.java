package frederick_daniel_restaurant_order;

public class Order {
    private int id;
    private String details;

    public Order(int id, String details) {
        this.id = id;
        this.details = details;
    }

    public void orderQueuing(Order order, ArrayQueue arrayQueue) {
        // System.out.println("Order Queuing... ");
        arrayQueue.enqueue(order);
        System.out.println("Order Added: " + order.toString());
    }

    public void orderProcessing(Order order, ArrayQueue arrayQueue, OrderStack orderStack) {
        System.out.println("Processing Order... ");
        arrayQueue.dequeue();
        orderStack.push(order);
        System.out.println("Processed Order: " + order.toString());
    }

    public void reviewProcessedOrder(Order order, OrderStack orderStack) {
        System.out.println("Reviewing Last Processed Order... ");
        orderStack.peek();
    }


    // Optional
    // public void undoLastProcessedOrder(Order order, ArrayQueue arrayQueue, OrderStack orderStack) {
    //     System.out.println("Undoing Last Processed Order... ");

    //     arrayQueue.dequeue();// This is wrong, this removes the front element but it need to remove the back element
    //     orderStack.pop(); // This should work 

    // }

    public String toString() {
        return "Order ID: " + id + ", Details: " + details;
    }

}
