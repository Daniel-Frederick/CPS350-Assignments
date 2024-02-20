package frederick_daniel_restaurant_order;

public class ArrayQueue {
    
    private Order[] queue; // Array to store queue elements
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private int size; // Number of elements in the queue
    private int capacity; // Maximum capacity of the queue

    // Constructor to initialize the queue
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new Order[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue    
    public void enqueue(Order order) {
        if (size < capacity) {
            rear = (rear + 1) % capacity; // Circular increment
            queue[rear] = order;
            size++;
        } else {
            System.out.println("Queue is full");
        }
    }

    // Method to remove and return the front element of the queue
    public Order dequeue() {
        if (size > 0) {
            Order order = queue[front];
            front = (front + 1) % capacity; // Circular increment
            size--;
            return order;
        } else {
            System.out.println("Queue is empty");
            return new Order(-1,null); // Return an error value or throw an exception
        }
    }

}
