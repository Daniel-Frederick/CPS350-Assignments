package frederick_daniel_restaurant_order;

public class ArrayQueue {
    
    private Order[] queue; // Array to store queue elements
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private int size; // Number of elements in the queue
    private int capacity; // Maximum capacity of the queue

    // Constructor to initialize the queue
    public ArrayQueue(int capacity) {
        this.capacity = capacity; // Create capacity for array size
        queue = new Order[capacity]; // Create array for queue
        front = 0; // Pointer to the front of the queue
        rear = -1; // Pointer to the back of the queue
        size = 0; // How many elements in array
    }

    // Method to add an order to the queue    
    public void enqueue(Order order) {
        if (size < capacity) { // Check if the array is full
            rear = (rear + 1) % capacity; // add the new order to the back of the queue so adjust rear
            queue[rear] = order; // Assign last element to the new order 
            size++; // Increase the size to keep track of how many orders are in queue
            System.out.println("Order Added: " + order.toString()); // Print the order was added successfully
        } else {
            // Print the order was not added successful because the queue is full
            System.out.println("Overflow! Can not add anymore orders!"); 
        }
    }

    // Method to remove and return the front order of the queue
    public void dequeue() {
        System.out.println("Processing Order... "); // Print that an attempt to remove an order was made
        if (size > 0) { // Check if the queue is not empty
            front = (front + 1) % capacity; // Remove the order from the front of the queue so adjust the front
            size--; // Adjust the size of the queue for removing an order
        } else {
            // Print the removal of an order was not successful because the queue is empty
            System.out.println("There are no orders to process!"); 
        }
    }

}
