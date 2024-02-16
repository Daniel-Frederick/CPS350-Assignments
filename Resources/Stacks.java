
/* Data Structure: Stack

notes: 
https://drive.google.com/file/d/1wJHHHWqm353zoHqWMJIRRQ-daiw3EPuz/view?usp=drive_link

methods:
push - adds a new element to the stack
pop - removes the top element from the stack
peek - Checks if the stack is empty or not
isEmpty - checks if the stack is empty (boolean)
size - returns the size of the stack

other methods:
empty - Removes all elements from stack
*/ 

//Skeleton class of a Java Stacks 
public class Stacks {
    private int[] stack; // Array to store stack elements
    private int top; // Index of the top element in the stack
    private int capacity; // Maximum capacity of the stack

    // Constructor to initialize the stack
    public Stacks(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1; // Stack is initially empty
    }

    // Method to add an element to the stack
    public void push(int item) {
        if (top < capacity - 1) {
            stack[++top] = item; // Increment top and add item
        } else {
            System.out.println("Stack is full");
        }
    }

    // Method to remove and return the top element of the stack
    public int pop() {
        if (top >= 0) {
            return stack[top--]; // Return top item and decrement top
        } else {
            System.out.println("Stack is empty");
            return -1; // Return an error value or throw an exception
        }
    }

    // Method to return the top element of the stack without removing it
    public int peek() {
        if (top >= 0) {
            return stack[top];
        } else {
            System.out.println("Stack is empty");
            return -1; // Return an error value or throw an exception
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to clear the stack
    public void clear() {
        top = -1; // Simply reset top to -1 to "clear" the stack
    }
}
