package frederick_daniel_graph_adjlist;

public class Edge {
  private String target;
  private int weight;

  // Constructor
  public Edge(String target, int weight) {
    this.target = target;
    this.weight = weight;
  }

  // Getters for target and weight
  public String getTarget() {
    return target;
  }

  public int getWeight() {
    return weight;
  }
}
