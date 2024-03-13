package resources.dataStructures;

public class Node {
    int data;
    Node left, right;

    // Node constructor initializes the node with data and null children
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
