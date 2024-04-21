import java.util.*;

public class topological {
    private int totalVertices;   // Total number of vertices in the graph
    private List<List<Integer>> adjacencyList; // Adjacency list to store directed edges
    private boolean[] visitedVertices;      // Array to track which vertices have been visited
    private Stack<Integer> topologicalOrderStack;  // Stack to store the topological order of vertices

    // Constructor to initialize the graph with a given number of vertices
    public topological(int numberOfVertices) {
        this.totalVertices = numberOfVertices;
        this.adjacencyList = new ArrayList<>();
        this.visitedVertices = new boolean[numberOfVertices];
        this.topologicalOrderStack = new Stack<>();
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());  // Initialize the adjacency list for each vertex
        }
    }

    // Method to add a directed edge from source vertex to destination vertex
    public void addDirectedEdge(int sourceVertex, int destinationVertex) {
        adjacencyList.get(sourceVertex).add(destinationVertex); // Add the destination vertex to the adjacency list of the source vertex
    }

    // Method to perform the custom topological sort
    public Stack<Integer> performCustomTopologicalSort() {
        // Attempt to find and process each vertex starting from the first to the last
        for (int currentVertex = 0; currentVertex < totalVertices; currentVertex++) {
            if (!visitedVertices[currentVertex] && allNeighborsVisited(currentVertex)) {
                depthFirstSearch(currentVertex); // Perform DFS if the vertex's neighbors are all visited
            }
        }
        return topologicalOrderStack; // Return the stack containing the topological order
    }

    // Recursive depth-first search method to visit vertices
    private void depthFirstSearch(int vertex) {
        visitedVertices[vertex] = true; // Mark the current vertex as visited
        // Recursively perform DFS on unvisited neighboring vertices that have all their neighbors visited
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visitedVertices[neighbor] && allNeighborsVisited(neighbor)) {
                depthFirstSearch(neighbor);
            }
        }
        topologicalOrderStack.push(vertex); // Push the current vertex to the stack after visiting all neighbors
    }

    // Method to check if all neighbors of the given vertex are visited
    private boolean allNeighborsVisited(int vertex) {
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visitedVertices[neighbor]) {
                return false; // Return false if any neighbor is not visited
            }
        }
        return true; // Return true if all neighbors are visited
    }

    // Main method to demonstrate the functionality of the graph and topological sort
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6); // Initialize the graph with 6 vertices
        graph.addDirectedEdge(5, 2); // Add edges as per the graph's structure
        graph.addDirectedEdge(5, 0);
        graph.addDirectedEdge(4, 0);
        graph.addDirectedEdge(4, 1);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 1);

        Stack<Integer> sortedVertices = graph.performCustomTopologicalSort(); // Perform the topological sort
        while (!sortedVertices.isEmpty()) {
            System.out.print(sortedVertices.pop() + " "); // Print the topological order
        }
    }
}