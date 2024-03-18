package frederick_daniel_AVLTree;

import java.util.Scanner;

public class AVLTreeDemo {
    private static AVLTree tree = new AVLTree();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            printMenu();
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    // Inserting works 100%
                    insertNode();
                    insertNodeRepeat();
                    break;
                case 2:
                    // Deleting works, I think
                    deleteNode();
                    break;
                case 3:
                    // Does not print the result to screen
                    searchNode();
                    break;
                case 4:
                    // Printing the tree in pre-order is correct 100%
                    printTree();
                    break;
                case 5:
                    // Exiting Works 100%
                    System.out.println("Existing Program... ");
                    System.exit(menu);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("AVL Tree Operations");
        System.out.println("1. Insert Node");
        System.out.println("2. Delete Node");
        System.out.println("3. Search Node");
        System.out.println("4. Print Tree");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void insertNode() {
        System.out.print("Enter the value to insert: ");
        int value = scanner.nextInt();
        tree.insert(value);
        scanner.nextLine(); // Consume input
        System.out.println("Node inserted successfully!");
    }

    private static void insertNodeRepeat() {
        while (true) {
            System.out.print("Would you like to insert anther node? (Yes/No): ");
            String insertAgain = scanner.nextLine().trim().toLowerCase();
            if (insertAgain.equals("yes") || insertAgain.equals("y")) {
                System.out.print("Enter integer value to insert: ");
                int value = scanner.nextInt();
                tree.insert(value);
            } else if (insertAgain.equals("no") || insertAgain.equals("n")) {
                break;
            }
            scanner.nextLine(); // Consume input
        }
    }
    

    private static void deleteNode() {
        System.out.print("Enter the value to delete: ");
        int value = scanner.nextInt();
        tree.delete(value);
    }

    private static void searchNode() {
        System.out.print("Enter Integer value to search: ");
        int data = scanner.nextInt();
        boolean found = tree.search(data);
        System.out.println("Search result for " + data + " : " + (found ? "Found" : "Not Found")); // Ternary Operator
    }

    private static void printTree() {
        System.out.println("Printing the AVL Tree...");
        tree.printPreOrder();
    }
}