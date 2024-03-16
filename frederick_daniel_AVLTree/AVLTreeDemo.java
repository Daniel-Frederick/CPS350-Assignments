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
                    insertNode();
                    break;
                case 2:
                    deleteNode();
                    break;
                case 3:
                    searchNode();
                    break;
                case 4:
                    printTree();
                    break;
                case 5:
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
        System.out.println("Node inserted successfully!");
    }

    private static void deleteNode() {
        System.out.print("Enter the value to delete: ");
        int value = scanner.nextInt();
        tree.delete(value);
    }

    private static void searchNode() {
        System.out.print("Enter the value to search: ");
        int value = scanner.nextInt();
        boolean found = tree.search(value);
    }

    private static void printTree() {
        System.out.println("Printing the AVL Tree...");
        tree.printPreOrder();
    }
}