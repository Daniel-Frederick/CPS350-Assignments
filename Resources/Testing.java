import DataStructures.Queues;
import DataStructures.Stacks;

public class Testing {

    public static void main(String[] args) {

        // Queues Testing
        Queues queue = new Queues(5); // Create a queue with capacity 5

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Peek at the front element
        System.out.println("Peek at front element: " + queue.peek()); // Should show 1

        // Dequeue elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeue element: " + queue.dequeue());
        }

        // Check if queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());



        // **** Stacks testing ****
        Stacks stack = new Stacks(5); // Create a stack with capacity 5

        // Push elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Peek at the top element
        System.out.println("Peek at top element: " + stack.peek()); // Should show 3

        // Pop elements
        while (!stack.isEmpty()) {
            System.out.println("Pop element: " + stack.pop());
        }

        // Check if stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());

        /*
        Stacks stack = new Stacks(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // Stack is full

        // Top of the stack
        System.out.println(stack.peek());

        // remove elements from stack
        System.out.println(stack.pop());

        // Make a new method in Stacks to empty the stack
        // Remove all elements from stack
        while(!stack.isEmpty()) { // Check to see if the stack is empty
            int value = stack.pop();
            System.out.println(value);
        }
        stack.empty(stack);
        System.out.println("stack is now emptied.");
        
        System.out.println(stack.size());

        
        Stacks bucket = new Stacks(4);

        System.out.println(bucket.isEmpty());
        bucket.push(1);
        System.out.println(bucket.size());

        bucket.push(2);
        System.out.println(bucket.size());

        bucket.push(3);
        System.out.println(bucket.size());
        System.out.println(bucket.peek());

        bucket.push(4);
        System.out.println(bucket.size());

        bucket.push(5);

        bucket.pop(); 

        bucket.push(5);  
        System.out.println(bucket.size());

        System.out.println(bucket.pop()+bucket.pop());
        System.out.println(bucket.pop());


        System.out.println(bucket.isEmpty());
        */
        
    }

}