package frederick_daniel_restaurant_order;

public class OrderStack {
    
    private Order[] stack; // Array to store stack elements
    private int top; // Index of the top element in the stack
    private int capacity; // Maximum capacity of the stack

    // Constructor to initialize the stack
    public OrderStack(int capacity) {
        this.capacity = capacity;
        stack = new Order[capacity];
        top = -1; // Stack is initially empty
    }

    // Method to add an element to the stack
    public void push(Order order) {
        if (top < capacity - 1) {
            stack[++top] = order; // Increment top and add item
        } else {
            System.out.println("Stack is full");
        }
    }

    // Method to remove and return the top element of the stack
    public Order pop() {
        if (top >= 0) {
            return stack[top--]; // Return top item and decrement top
        } else {
            System.out.println("Stack is empty");
            return new Order(-1,null); // Return an error value or throw an exception
        }
    }

    public Order peek() {
        if (top >= 0) {
            return stack[top];
        } else {
            System.out.println("Stack is empty");
            return new Order(-1,null); // Return an error value or throw an exception
        }
    }

}
