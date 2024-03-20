package frederick_daniel_AVLTree;

public class AVLTree {
    private Node root; // Create a variable for the root Node

    // Constructor
    public AVLTree() {
        root = null; // Start root node with nothing in it
    }

    // Getter method for root
    public Node getRoot() {
        return root; 
    }

    // Getter method to get the height of a Node
    public int getHeight(Node node) {
        if (node == null) // If the tree is empty, then return 0 since there are no Nodes
            return 0;
        return node.height; // else return the node height
    }

    // Calculates if the tree is Balanced or not 
    public int getBalanceFactor(Node node) {
        if (node == null) // If the tree is empty, then the balance factor is 0
            return 0;
        // Using the children of the root Node, find the depth of both sides and subtract them
        return getHeight(node.left) - getHeight(node.right);
        // If balanced, the answer will be -1,0, or 1; otherwise, it is not balanced
    }

    // Rotates the subtree for the Left Left Case
    public Node rotateRight(Node node) { // Takes in the root of the subtree
        Node leftChild = node.left; // Get the left Node of the subtree root
        Node grandChild = leftChild.right; // Get the right Grand child of the subtree root

        leftChild.right = node; // Set the right child of the leftChild to be the original node
        node.left = grandChild; // Set the left child of the original node to be the grandChild

        // Adjust the heights for each node that were rotated
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        leftChild.height = 1 + Math.max(getHeight(leftChild.left), getHeight(leftChild.right));

        return leftChild;
    }

    // Rotates the subtree for the Right Right Case
    public Node rotateLeft(Node node) { // Takes in the root of the subtree
        Node rightChild = node.right; // Get the right Node of the subtree root
        Node grandChild = rightChild.left; // Get the left Grand child of the subtree root

        rightChild.left = node; // Set the left child of the rightChild to be the original node
        node.right = grandChild; // Set the right child of the original node to be the grandChild

        // Adjust the heights for each node that were rotated
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        rightChild.height = 1 + Math.max(getHeight(rightChild.left), getHeight(rightChild.right));

        return rightChild;
    }

    /**
     * Method to insert a new Node into the AVLTree
     * @param node -The current Node, already in the tree, to compare with the new value 
     * @param data -The new value the user wants to input into the AVLTree
     * @return Node
     */
    public Node insert(Node node, int data) {
        // Base case: If the AVLTree is empty, Create new Node to be the root 
        if (node == null) // If the AVLTree is empty, then the first Node entered is the root
            return new Node(data);

        // If the AVLTree is NOT empty
        if (data < node.data) // Is the new Node less than the subtree root?
            // If true: using recursion, go to the left child of the current Node
            node.left = insert(node.left, data); 
        else if (data > node.data) // Is the new Node greater than the subtree root?
            // If true: using recursion, go to the right child of the current Node
            node.right = insert(node.right, data);
        else // Tests: if(data == node.data)
            // AVLTrees are not allowed to have duplicate values
            return node; // Return the current Node and don't insert anything
        // We have entered a new Node into the Tree!

        // Calculates the height of the current node based on the heights of its left and right subtrees
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // After inserting the new Node, check if the AVLTree is still balanced
        int balanceFactor = getBalanceFactor(node);
        // If balanceFactor equals -1,0, or 1, the below statements will not be necessary as the tree is still balanced

        // Tree is unbalaced according to the Left Left Case
        if (balanceFactor > 1 && data < node.left.data)
            // Rotate the AVLTree to the right to even out the subtree
            return rotateRight(node);

        // Tree is unbalaced according to the Right Right Case
        if (balanceFactor < -1 && data > node.right.data)
            // Rotate the AVLTree to the left to even out the subtree
            return rotateLeft(node);

        // Tree is unbalaced according to the Left Right Case
        if (balanceFactor > 1 && data > node.left.data) {
            // If true, perform a left rotation on the left child of the current node to balance its left subtree
            node.left = rotateLeft(node.left);
            // Perform a right rotation on the current node to balance the tree
            return rotateRight(node);
        }

        // Tree is unbalaced according to the Right Left Case
        if (balanceFactor < -1 && data < node.right.data) {
            // If true, perform a right rotation on the right child of the current node to balance its right subtree
            node.right = rotateRight(node.right);
            // Perform a left rotation on the current node to balance the tree
            return rotateLeft(node);
        }
        // The Tree is now Balanced!
        
        return node; 
    }

    // Helper method for inserting a new Node
    public void insert(int data) {
        root = insert(root, data);
    }

    // Searching for a Node
    public Node search(Node node, int data) {
        // node == null : Checks if the current node is empty
        // node.data == data : Checks if you found the Node with the correct value
        if (node == null || node.data == data)
            return node;

        // Checks if value you are looking for is less than the current Node
        if (data < node.data)
            // If less than, using recursion, move to the left child
            return search(node.left, data);
        else // If the value is not less than the Node value, then it is greater
            // If greater than, using recursion, move to the right child
            return search(node.right, data);
    }

    // Helper method that returns a boolean if you found the Node or not.
    public boolean search(int data) {
        Node result = search(root, data);
        // result will either be "null" or the correct Node
        return result != null; // Returns true if the Node is not "null"
    }

    public Node deleteNode(Node node, int data) {
        // Base case: If the AVLTree is empty, return null
        if (node == null)
            return node;
    
        // If the AVLTree is NOT empty
        if (data < node.data) // Is the data to be deleted less than the subtree root?
            // If true: using recursion, go to the left child of the current Node
            node.left = deleteNode(node.left, data);
        else if (data > node.data) // Is the data to be deleted greater than the subtree root?
            // If true: using recursion, go to the right child of the current Node
            node.right = deleteNode(node.right, data);
        else { // If the data to be deleted is found
            if (node.left == null || node.right == null) { // Check if Node has 0 or 1 children
                Node temp = null; // Temporary variable to replace the deleted node with child
                if (temp == node.left) // Check if the child is the right node
                    // If true: the node has a right child, set temp to the right child
                    temp = node.right; 
                else
                    // The Node might have a left child, set temp to the left child
                    temp = node.left;
    
                // Check if node has a child
                if (temp == null) { // Check if Node is a leaf
                    // If temp is still null, it means the node is a leaf node
                    temp = node;
                    node = null; // Delete the node
                } else // Node has 1 child
                    node = temp; // Replace the node with its child
            } else { // Node has 2 children
                // Find the inorder successor: mininum value node in the right subtree
                Node temp = minValueNode(node.right);
                // Copy the inorder successor's data to this node
                node.data = temp.data;
                // Delete the inorder successor
                node.right = deleteNode(node.right, temp.data);
            }
        }
        // We have deleted a Node from the tree!
    
        // If the tree had only one node, then return
        if (node == null) // Check if the tree is empty
            return node;
    
        // Update the height of the current node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    
        // Get the balance factor of the current node
        int balanceFactor = getBalanceFactor(node);
    
        // If the balance factor indicates an unbalanced condition, perform rotations to balance the tree
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            // If true, perform a right rotation on the current node to balance the tree
            return rotateRight(node);

        // Check if the balance factor of the current node indicates a left-heavy subtree and the balance factor of its left child is negative
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            // If true, perform a left rotation on the left child of the current node to balance its left subtree
            node.left = rotateLeft(node.left);
            // Perform a right rotation on the current node to balance the tree
            return rotateRight(node);
        }

        // Check if the balance factor of the current node indicates a right-heavy subtree and the balance factor of its right child is non-positive
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            // If true, perform a left rotation on the current node to balance the tree
            return rotateLeft(node);

        // Check if the balance factor of the current node indicates a right-heavy subtree and the balance factor of its right child is positive
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            // If true, perform a right rotation on the right child of the current node to balance its right subtree
            node.right = rotateRight(node.right);
            // Perform a left rotation on the current node to balance the tree
            return rotateLeft(node);
        }

        return node;
    }    

    // Helper method for deleteNode method
    public void delete(int data) {
        root = deleteNode(root, data);
    }

    // Finds the minimum value in the tree
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) // The smallest node will be the farthest node to the left
            // Continue the loop until you get to the left most node
            current = current.left;
        return current; // Return the smallest node
    }

    // Prints the tree in Pre-Order
    public void preOrderTraversal(Node node) {
        if (node != null) { // This will always be true due to the helper method
            System.out.print(node.data + " "); // Prints the data of the root node 
            preOrderTraversal(node.left); // Using recursion, move throughout the left side of the tree
            preOrderTraversal(node.right); // Using recursion, move throughout the right side of the tree
        }
    }

    // Helper method for preOrderTraversal
    public void printPreOrder() {
        System.out.println("Pre-order traversal of the AVL Tree:");
        if(root == null) { // If the AVLTree is empty, then tell the user
            System.out.println("AVLTree is Empty");
        }
        else { // If the tree is not empty, then print the pre-Order
        preOrderTraversal(root);
        }
        System.out.println(); // add spacing
    }
}