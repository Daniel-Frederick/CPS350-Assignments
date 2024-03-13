package resources.dataStructures.linear;

/* Data Structure: Stack
FIFO - First In First Out

notes: 

methods:
enqueue - Method to add an element to the queue
dequeue - Method to remove and return the front element of the queue
isEmpty - Method to check if the queue is empty
isFull - Method to check if the queue is full
peek - Method to get the front element of the queue without removing it
*/ 

// Skeleton class of a Java Queue
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

    // Method to add an element to the queue. O(1)
    public void enqueue(int item) {
        if (size < capacity) {
            rear = (rear + 1) % capacity; // Circular increment
            size++;
            queue[rear] = item;
        } else {
            System.out.println("Queue is full");
        }
    }

    // Method to remove and return the front element of the queue. O(1)
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

    // Method to check if the queue is empty. O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full. O(1)
    public boolean isFull() {
        return size == capacity;
    }

    // Method to get the front element of the queue without removing it. O(1)
    public int peek() {
        if (size > 0) {
            return queue[front];
        } else {
            System.out.println("Queue is empty");
            return -1; // Return an error value or throw an exception
        }
    }
}