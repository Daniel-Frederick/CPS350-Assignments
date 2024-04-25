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

        if (!adjacencyLists.get(source).stream().anyMatch(edge -> edge.getTarget().equals(target))) {
            // Both vertices exist, and there is no existing edge from source to target, so add the connection for the source vertex
            adjacencyLists.get(source).add(new Edge(target, weight));
            System.out.println("Edge added successfully: " + source + " -> " + target + " (Weight: " + weight + ")");
        }
        else {
            System.out.println("You already have a connection made from \'" + source + "\' to \'" + target + "\'");
        }
    }

    public String generateGraphRepresentation() {
        String graphRepresentation = "";
    
        for (String vertex: adjacencyLists.keySet()) {
            graphRepresentation += "Vertex " + vertex + ": ";
    
            List<Edge> edges = adjacencyLists.get(vertex);
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                graphRepresentation += "[" + edge.getTarget() + "  " + "(" + edge.getWeight() + ")]";
    
                if (i != edges.size() - 1) {
                    graphRepresentation += ", ";
                }
            }
    
            graphRepresentation += "\n";
        }
    
        return graphRepresentation;
    }

}