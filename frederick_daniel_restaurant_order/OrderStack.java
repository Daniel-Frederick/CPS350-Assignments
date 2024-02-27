package frederick_daniel_restaurant_order;

public class OrderStack {
    
    private Order[] stack; // Array to store stack elements
    private int top; // Index of the top element in the stack
    private int capacity; // Maximum capacity of the stack

    // Constructor to initialize the stack
    public OrderStack(int capacity) {
        this.capacity = capacity; // Create capacity for array size
        stack = new Order[capacity];
        top = -1; // Pointer to the top of the stack  
    }

    // Method to add an order to the stack
    public void push(Order order) {
        if (top < capacity - 1) { // Check if the queue is full
            stack[++top] = order; // Assign new order to the next spot in the stack and increment top 
            System.out.println("Processed Order: " + order.toString()); // Print the order was successful processed
        } else {
            // The queue is full and print that the new order was not added 
            System.out.println("Overflow! There are too many orders!");
        }
    }

    // Method to remove an order from the stack
    public void pop() {
        System.out.println("Undoing Last Processed Order... "); // Print that an attempt to undo an order was made
        if (top >= 0) { // Check if the stack is not empty
            // The stack is not empty and remove the top element
            System.out.println("Order removed: " + stack[top--]); // Print the removed order 
        } else {
            // The stack is empty and print there are no orders to remove
            System.out.println("There are no orders to remove!"); 
        }
    }

    // Method to view the order at the top of the stack
    public void peek() {
        System.out.println("Reviewing Last Processed Order... "); // Print that an attempt to view the top order was made
        if (top >= 0) { // Check if the stack is not empty
            // The stack is not empty
            System.out.println("Last Order Processed: " + stack[top].toString()); // Print the top order
        } else {
            // The stack is empty and print there are no orders to process
            System.out.println("There are no processed orders!"); 
        }
    }

}
