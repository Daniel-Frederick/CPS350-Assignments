package frederick_daniel_BST;

public class Node {
    int data; // Node value
    int height;
    Node left, right; // Left and Right children

    // Node constructor initializes the node with data and null children
    public Node(int data, int height) {
        this.data = data;
        this.height = height;
        left = right = null; // Children initially start at null
    }
}
