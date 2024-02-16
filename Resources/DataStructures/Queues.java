package resources.dataStructures;
public class Queues {

    private int[] queue; // Array to store queue elements
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private int size; // Number of elements in the queue
    private int capacity; // Maximum capacity of the queue

    // Constructor to initialize the queue
    public Queues(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        if (size < capacity) {
            rear = (rear + 1) % capacity; // Circular increment
            queue[rear] = item;
            size++;
        } else {
            System.out.println("Queue is full");
        }
    }

    // Method to remove and return the front element of the queue
    public int dequeue() {
        if (size > 0) {
            int item = queue[front];
            front = (front + 1) % capacity; // Circular increment
            size--;
            return item;
        } else {
            System.out.println("Queue is empty");
            return -1; // Return an error value or throw an exception
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to get the front element of the queue without removing it
    public int peek() {
        if (size > 0) {
            return queue[front];
        } else {
            System.out.println("Queue is empty");
            return -1; // Return an error value or throw an exception
        }
    }
}