package resources.dataStructures;
import java.util.PriorityQueue; // Import for PriorityQueue

/* Data Structure: Priority Queue
The difference between a queue and a priority queue:
    Priority queues do not strictly adhere to the FIFO principle;
    rather, they ensure that elements are removed or added in order of their priority.


Built in Java Object for Priority Queues.
Built in methods for PriorityQueues:
add: boolean - Adds an element. If full: throw exception
offer: boolean - Adds an element. If full: return false
remove - Removes an element. If empty: throw exception
poll - Removes an element. If empty: return null
element - Returns first/head element. If empty: throw exception
peek - Returns first/head element. If empty: return null
isEmpty: boolean - Returns true if this collection contains no elements, else false.
clear - Removes all of the elements from priority queue
size - Returns the number of elements in queue
 */

// Uses of the PriorityQueues object methods
public class PriorityQueues {
    
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add a new element to the Priortity Queue
        priorityQueue.add(6);
        priorityQueue.offer(4);
        // Will automatically order from least to greatest

        // Print Queue 
        System.out.println(priorityQueue); // defaults to running .toString()

        // Returns the number of elements in queue
        System.err.println(priorityQueue.size());

        // Returns first/head element in queue
        System.out.println(priorityQueue.peek()); // Returns first/head element. If empty: return null
        System.out.println(priorityQueue.element()); // Returns first/head element. If empty: throw exception

        // Returns true if this collection contains no elements, else false.
        System.out.println(priorityQueue.isEmpty());

        // Remove an element from the Priortity Queue
        priorityQueue.remove(); // Throws Exception if Queue is empty
        priorityQueue.poll(); // Returns null if queue is empty

        // Removes all of the elements from priority queue
        priorityQueue.clear();

    }

}
