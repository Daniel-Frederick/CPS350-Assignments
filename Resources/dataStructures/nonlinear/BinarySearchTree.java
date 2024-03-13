package resources.dataStructures.nonlinear;
import java.util.LinkedList;
import java.util.Queue;

/* Data Structure: Binary Search Tree




 */

public class BinarySearchTree {    
    Node root; // The root node of the binary tree

	 // Constructor for BinaryTree
	 public BinarySearchTree() {
        root = null; // Initializes the root of the binary tree to null
    }

    // ------- Level Order(LNR) ----------
	// Method for level order traversal of the binary tree
    void levelOrder(Node root) {
	    // If the tree is empty, return immediately
	    if (root == null) {
	        return;
	    }
	    Queue<Node> queue = new LinkedList<>(); // Create a queue to hold nodes at each level
	    queue.add(root); // Start with the root
	     
	    // Continue until there are no more nodes to process
	    while (!queue.isEmpty()) {
		    Node current = queue.poll(); // Retrieve and remove the head of the queue
		    System.out.print(current.data + " "); // Print the data of the current node
		         
		    // If the current node has a left child, add it to the queue
		    if (current.left != null) {
		         queue.add(current.left);
		    }
		    // If the current node has a right child, add it to the queue
		    if (current.right != null) {
	            queue.add(current.right);
	        }
     	}
 	 }
	
	// Utility method to start level order traversal from the root of the tree
    public void levelOrderTraversal() {
	    levelOrder(root);
	}


    // ------- Pre-Order(LNR) ----------
    // Recursive method for preorder traversal of the binary tree
	void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " "); // First, visit the root node and print its data
            preOrder(node.left); // Then, recur on the left subtree
            preOrder(node.right); // Finally, recur on the right subtree
        }
    }
   
    // Utility method to start preorder traversal from the root
    public void preOrderTraversal() {
        preOrder(root);
    }

    // ---- Insert new Node/Value ----
    // Public method to insert a new node with the specified data
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Helper method for insert operation, works recursively
    private Node insertRec(Node root, int data) {
        // Base case: If the current node is null, create a new node with the data
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Recursive case: Decide whether to insert the node in the left or right subtree
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        // Return the unchanged node pointer
        return root;
    }

    // ---- in-order Traversal ----
    // Public method to perform inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
        System.out.println(); // New line after traversal
    }

    // Helper method for inorder traversal, works recursively
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Traverse left subtree
            System.out.print(root.data + " "); // Visit node
            inorderRec(root.right); // Traverse right subtree
        }
    }

    // ---- Searching ----
    // Public method to search for a node with the specified data
    public boolean search(int data) {
        return searchRec(root, data);
    }

    // Helper method for search operation, works recursively
    private boolean searchRec(Node root, int data) {
        // Base case: if root is null or the root's data matches the search data
        if (root == null || root.data == data) {
            return root != null;
        }

        // Decide whether to search in the left or right subtree
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    // ---- Deletion ----
    // Public method to delete a node with the specified data
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Helper method for delete operation, works recursively
    private Node deleteRec(Node root, int data) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Recursive case: Find the node to be deleted
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    // Helper method for deleteRec
    // Finds the smallest value in a subtree
    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

}
