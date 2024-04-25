package frederick_daniel_graph_adjlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
  
  private Map<String, List<Edge>> adjacencyLists; // Initiate a Map for the Graph 
  
  public Graph() {
    // Keys: Vertex
    // Values: All Connections
    this.adjacencyLists = new HashMap<>(); // Create a HashMap Object 
  }

  // Method to add a Vertex to the Graph
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

  // Method to add an Edge to the Graph
  public void addEdge(String source, String target, int weight) {
    // Check if the user entered two vertices that are in the Graph, if not, tell the user and return nothing
    if (!adjacencyLists.containsKey(source)) {
      System.out.println("Error: Vertex \'" + source + "\' does not exist. Please add the vertex before creating an edge.");
      return;
    }

    if (!adjacencyLists.containsKey(target)) { // Add target vertex if it doesn't exist
      System.out.println("Error: target \'" + target + "\' does not exist. Please add the vertex before creating an edge.");
      return;
    }

    // Check if the connection is already made in the Graph
    if (!adjacencyLists.get(source).stream().anyMatch(edge -> edge.getTarget().equals(target))) {
      // Both vertices exist, and there is no existing edge from source to target, so add the connection for the source vertex
      adjacencyLists.get(source).add(new Edge(target, weight));
      System.out.println("Edge added successfully: " + source + " -> " + target + " (Weight: " + weight + ")");
    }
    else {
      // The connection is already made
      System.out.println("You already have a connection made from \'" + source + "\' to \'" + target + "\'");
    }
  }

  // Method to display the Graph to the user
  public String displayGraph() {
    String graphRepresentation = ""; // Initlize an empty String
  
    // Loop through all the keys from a Set
    for (String vertex: adjacencyLists.keySet()) {
      // Add the name of the vertex to the String 
      graphRepresentation += "Vertex " + vertex + ": ";
  
      // List edges created to store the list of edges associated with a particular vertex for readability
      List<Edge> edges = adjacencyLists.get(vertex); 
      for (int i = 0; i < edges.size(); i++) { // Loop throughthe edges in the particular vertex
        Edge edge = edges.get(i); // Get the vertex's connection
        graphRepresentation += "[" + edge.getTarget() + "  " + "(" + edge.getWeight() + ")]"; // Add the connection to the String
  
        if (i != edges.size() - 1) { // Add a comma between multiple connections
          graphRepresentation += ", ";
        }
      }
  
      // Add an indent to the String for easy readability
      graphRepresentation += "\n";
    }
    return graphRepresentation; // return the finished String
  }
}
