package frederick_daniel_AVLTree;

public class Node {
    int data; // Node value
    int height;
    Node left, right; // Left and Right children

    // Node constructor initializes the node with data and null children
    public Node(int data) {
        this.data = data;
        this.height = 1;
        left = right = null; // Children initially start at null
    }
}