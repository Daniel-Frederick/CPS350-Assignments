package frederick_daniel_graph_adjlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    
    private Map<String, List<Edge>> adjacencyLists;
    
    public Graph() {
        this.adjacencyLists = new HashMap<>();
    }
    
    public void addVertex(String vertex) {
        if (!adjacencyLists.containsKey(vertex)) {
            adjacencyLists.put(vertex, new ArrayList<>());
        }
    }
    
    public void addDirectedEdge(String source, String target, int weight) {
        if (!adjacencyLists.containsKey(source) || !adjacencyLists.containsKey(target)) {
            throw new IllegalArgumentException("One or both vertices do not exist.");
        }
        adjacencyLists.get(source).add(new Edge(target, weight));
    }
    
    public List<Edge> getAdjacentVertices(String vertex) {
        return adjacencyLists.getOrDefault(vertex, new ArrayList<>());
    }
    
    public String generateGraphRepresentation() {
        StringBuilder representation = new StringBuilder();
        for (String vertex : adjacencyLists.keySet()) {
            representation.append(vertex).append(" -> ");
            List<Edge> edges = adjacencyLists.get(vertex);
            for (Edge edge : edges) {
                representation.append("(").append(edge.getTarget()).append(", ").append(edge.getWeight()).append(") ");
            }
            representation.append("\n");
        }
        return representation.toString();
    }
}