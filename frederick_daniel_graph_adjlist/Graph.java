package frederick_daniel_graph_adjlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    
    private Map<String, List<Edge>> adjacencyLists;
    
    public Graph() {
        // Keys: Vertex
        // Values: All Connections
        this.adjacencyLists = new HashMap<>();
    }
    
    public void addVertex(String vertex) {
        // Check if the vertex is already in HashMap
        if (!adjacencyLists.containsKey(vertex)) { // Go through all keys and see if the vertex already exists
            // The vertex does not exist
            adjacencyLists.put(vertex, new ArrayList<>());
            System.out.println("Vertex \'" + vertex + "\' added successfully.");
        }
        else {
            // The Vertex already exists
            System.out.println("The vertex is already made!");
        }
    }

    public void addDirectedEdge(String source, String target, int weight) {
        // Add source vertex if it doesn't exist
        if (!adjacencyLists.containsKey(source)) {
            System.out.println("Error: Vertex \'" + source + "\' does not exist. Please add the vertex before creating an edge.");
            return;
        }

        if (!adjacencyLists.containsKey(target)) { // Add target vertex if it doesn't exist
            System.out.println("Error: target \'" + target + "\' does not exist. Please add the vertex before creating an edge.");
            return;
        }
    
        // Both vertices exist (or have been added), so add the connection for the source vertex
        adjacencyLists.get(source).add(new Edge(target, weight));
        System.out.println("Edge added successfully: " + source + " -> " + target + " (Weight: " + weight + ")");        
    }

    public String generateGraphRepresentation() {
        StringBuilder graphRepresentation = new StringBuilder();
    
        for (String vertex : adjacencyLists.keySet()) {
            graphRepresentation.append("Vertex ").append(vertex).append(": ");
    
            List<Edge> edges = adjacencyLists.get(vertex);
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                graphRepresentation.append("[").append(edge.getTarget()).append("  ").append("(").append(edge.getWeight()).append(")").append("]");
    
                if (i != edges.size() - 1) {
                    graphRepresentation.append(", ");
                }
            }
    
            graphRepresentation.append("\n");
        }
    
        return graphRepresentation.toString();
    }

}