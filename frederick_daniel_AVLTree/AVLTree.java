package frederick_daniel_AVLTree;

public class AVLTree {
    private Node root;

    public AVLTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    public int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public Node rotateRight(Node node) {
        Node leftChild = node.left;
        Node grandChild = leftChild.right;

        leftChild.right = node;
        node.left = grandChild;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        leftChild.height = 1 + Math.max(getHeight(leftChild.left), getHeight(leftChild.right));

        return leftChild;
    }

    public Node rotateLeft(Node node) {
        Node rightChild = node.right;
        Node grandChild = rightChild.left;

        rightChild.left = node;
        node.right = grandChild;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        rightChild.height = 1 + Math.max(getHeight(rightChild.left), getHeight(rightChild.right));

        return rightChild;
    }

    public Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node; // Duplicate datas are not allowed

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);

        // Left Left Case
        if (balanceFactor > 1 && data < node.left.data)
            return rotateRight(node);

        // Right Right Case
        if (balanceFactor < -1 && data > node.right.data)
            return rotateLeft(node);

        // Left Right Case
        if (balanceFactor > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balanceFactor < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node search(Node node, int data) {
        if (node == null || node.data == data)
            return node;

        if (data < node.data)
            return search(node.left, data);
        else
            return search(node.right, data);
    }

    public boolean search(int data) {
        Node result = search(root, data);
        return result != null;
    }

    public Node deleteNode(Node node, int data) {
        if (node == null)
            return node;

        if (data < node.data)
            node.left = deleteNode(node.left, data);
        else if (data > node.data)
            node.right = deleteNode(node.right, data);
        else {
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;

                if (temp == null) {
                    temp = node;
                    node = null;
                } else
                    node = temp;
            } else {
                Node temp = minValueNode(node.right);
                node.data = temp.data;
                node.right = deleteNode(node.right, temp.data);
            }
        }

        if (node == null)
            return node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rotateRight(node);

        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return rotateLeft(node);

        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void delete(int data) {
        root = deleteNode(root, data);
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Prints the tree in Pre-Order
    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void printPreOrder() {
        System.out.println("Pre-order traversal:");
        preOrderTraversal(root);
        System.out.println();
    }
}