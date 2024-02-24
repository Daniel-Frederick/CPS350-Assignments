package resources.dataStructures;
import java.util.PriorityQueue; // Import for PriorityQueue

/* Data Structure: Priority Queue
The difference between a queue and a priority queue:
    Priority queues do not strictly adhere to the FIFO principle;
        rather, they ensure that elements are removed or added in order of their priority.



Built in Java Object for Priority Queues.
Built in methods for PriorityQueues:
add
offer
remove
poll
element
peek
isEmpty
clear
size

 */

// Uses of the PriorityQueues object methods
public class PriorityQueues {
    
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add a new element to the Priortity Queue
        priorityQueue.offer(4);
        priorityQueue.add(6);

        // Remove an element from the Priortity Queue
        priorityQueue.remove(); // Throws Exception if Queue is empty
        priorityQueue.poll(); // Returns null if queue is empty


    }

}
