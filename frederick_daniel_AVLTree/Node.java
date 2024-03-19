package frederick_daniel_AVLTree;

public class Node {
    int data; // Node value
    int height; // Node tree height
    Node left, right; // References to Left and Right children

    // Node constructor initializes the node with data and null children
    public Node(int data) { 
        this.data = data; // Assign the value to the Node
        this.height = 1; // First height is height 1
        left = right = null; // Children references initially start at null
    }
}