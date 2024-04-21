/* Explanation of Kahn's Algorithm  
Initialization: 
  An array in_degree is used to keep track of the number of incoming edges for each vertex.
  A queue is used to keep track of all vertices with no incoming edges.

Process: 
  Vertices with no incoming edges are removed from the queue, and the vertex is added to the topological order.
  For each removed vertex, it decrements the in-degree of its adjacent vertices.
  If decrementing results in an adjacent vertex having no remaining incoming edges, it is added to the queue.

Cycle Detection:
  If all vertices are not visited after the queue empties, it indicates that there is a cycle in the graph, and thus, topological sorting is not possible.
 */

import java.util.*;

public class kahn_algorithm {
    private int numberOfVertices;   // Number of vertices in the graph
    private ArrayList<ArrayList<Integer>> adjacencyList; // Adjacency list to store the graph

    // Constructor to initialize the graph with a given number of vertices
    kahn_algorithm(int vertices) {
        numberOfVertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Function to add a directed edge from vertex source to vertex destination
    void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    // Function to perform topological sort using Kahn's Algorithm
    ArrayList<Integer> performTopologicalSort() {
        int[] incomingEdgeCount = new int[numberOfVertices]; // Array to store incoming edge counts for all vertices
        ArrayList<Integer> topologicalOrder = new ArrayList<>(); // List to store the topological order

        // Calculate incoming edge count (number of incoming edges) for each vertex
        for (int i = 0; i < numberOfVertices; i++) {
            for (int vertex : adjacencyList.get(i)) {
                incomingEdgeCount[vertex]++;
            }
        }

        // Queue to store all vertices with no incoming edges (incoming edge count = 0)
        Queue<Integer> zeroIncomingQueue = new LinkedList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            if (incomingEdgeCount[i] == 0)
                zeroIncomingQueue.add(i);
        }

        int visitedVertexCount = 0; // Counter for the number of vertices visited

        // Process vertices in the queue
        while (!zeroIncomingQueue.isEmpty()) {
            int currentVertex = zeroIncomingQueue.poll(); // Remove a vertex from the queue
            topologicalOrder.add(currentVertex); // Add it to the topological order

            // Iterate over all its neighbouring nodes and decrease their incoming edge count by 1
            for (int adjacentVertex : adjacencyList.get(currentVertex)) {
                // If incoming edge count of an adjacent vertex is reduced to zero, add it to the queue
                if (--incomingEdgeCount[adjacentVertex] == 0)
                    zeroIncomingQueue.add(adjacentVertex);
            }
            visitedVertexCount++; // Increment count of visited vertices
        }

        // Check if there was a cycle in the graph
        if (visitedVertexCount != numberOfVertices) {
            System.out.println("There exists a cycle in the graph");
            return null; // Return null if a cycle was detected (topological sorting not possible)
        }

        return topologicalOrder; // Return the topological order
    }

    public static void main(String args[]) {
        kahn_algorithm graph = new kahn_algorithm(6); // Create a graph with 6 vertices
        graph.addEdge(5, 2); // Add edges as per the graph's structure
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological Sort of the given graph:");
        ArrayList<Integer> result = graph.performTopologicalSort(); // Perform topological sorting
        if (result != null) {
            for (int vertex : result)
                System.out.print(vertex + " ");
            System.out.println();
        }
    }
}