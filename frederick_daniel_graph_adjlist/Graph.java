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
    
    // There is a problem here. 2 Valid vertices do not get past the first if, always saying they don't exist
    public void addDirectedEdge(String source, String target, int weight) {
        // Check if source and target are valid vertices
        if (!adjacencyLists.containsKey(source) || !adjacencyLists.containsKey(target)) {
            // One or both of the entered vertices does not exist
            System.out.println("One or both vertices do not exist.");
        }
        else {
            // Both Vertices exist so add the connection for the source vertex
            adjacencyLists.get(source).add(new Edge(target, weight));
            System.out.println("Edge added successfully " + source + " -> " + target + " (Weight: " + weight + ")");
        }
    }

    public String generateGraphRepresentation() {
        StringBuilder graphRepresentation = new StringBuilder();
    
        for (String vertex : adjacencyLists.keySet()) {
            graphRepresentation.append(vertex).append(": ");
    
            List<Edge> edges = adjacencyLists.get(vertex);
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                graphRepresentation.append("(").append(edge.getTarget()).append(", ").append(edge.getWeight()).append(")");
    
                if (i != edges.size() - 1) {
                    graphRepresentation.append(", ");
                }
            }
    
            graphRepresentation.append("\n");
        }
    
        return graphRepresentation.toString();
    }
    
    // public List<Edge> getAdjacentVertices(String vertex) {
    //     return adjacencyLists.getOrDefault(vertex, new ArrayList<>());
    // }

}