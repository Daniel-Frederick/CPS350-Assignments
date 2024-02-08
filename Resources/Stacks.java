
/* Data Structure: Stack

notes: 
https://drive.google.com/file/d/1wJHHHWqm353zoHqWMJIRRQ-daiw3EPuz/view?usp=drive_link

methods:
push - adds a new element to the stack
pop - removes the top element from the stack
peek - Checks if the stack is empty or not
isEmpty - checks if the stack is empty (boolean)
size - returns the size of the stack
*/ 

//Skeleton class of a Java Stacks 
public class Stacks {
	// max size
	private int maxSize;

	//array will store elements of the stack
	private int[] stackArray;

	// index of the top element of the stack
	private int top;

	// constructor
	public Stacks(int size) {
		this.maxSize = size;
		this.stackArray = new int[maxSize];
		// // stack is empty
		this.top = -1;
	}

	// push elements into the stack
	public void push(int value) {
		// check if stack full
		if(top  < maxSize - 1) {
			//go to top and add value (++ increment)
			stackArray[++top] = value;
		}
		else {
			System.out.println("Stack is full, cannot push more values");
		}
	}

	// pop elements 
	public int pop() {
		if(top >= 0) {
			// return top value and decrement
			return stackArray[top--];
		}else {
			System.out.println("Stack is empty, cannot pop values");
		}
		//return invalid value
		return -1;
	}

	// method to check if stack empty or not
	public int peek() {
		// check if stack is not empty
		if(top >=0) {
			// Return the top element
			return stackArray[top];
		}else {
			System.out.println("Stack is empty,unable to peek");
		}
		//return invalid value
		return -1;
	}

	// check if the stack is completely empty
	public boolean isEmpty() {
		return (top == -1);

	}

	// check the size of the stack
	public int size() {
		return top + 1;
	}
}