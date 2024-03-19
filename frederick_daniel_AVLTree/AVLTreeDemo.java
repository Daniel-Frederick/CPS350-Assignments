package frederick_daniel_AVLTree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AVLTreeDemo {
    private static AVLTree tree = new AVLTree();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int menu;
            while(true) {
                printMenu();
                // int menu = scanner.nextInt();
                if(scanner.hasNextInt()) { // Check if input is an integer
                    menu = scanner.nextInt();
                    break;
                }
                else {
                    System.out.println("Invalid input. Please enter one of the options!");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            switch (menu) {
                case 1:
                    // Inserting works 100%
                    insertNodeRepeat();
                    break;
                case 2:
                    // Deleting works, I think
                    deleteNode();
                    break;
                case 3:
                    // Searching works 100%
                    searchNode();
                    break;
                case 4:
                    // Printing works 100%
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
        System.out.println();
        System.out.println("AVL Tree Operations");
        System.out.println("1. Insert Node");
        System.out.println("2. Delete Node");
        System.out.println("3. Search Node");
        System.out.println("4. Print Tree");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void insertNodeRepeat() {
    String insertAgain;
    do {
        System.out.print("Enter integer value to insert: ");
        int value;
        while (true) {
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch (Exception e) { // User entered a String instead of integer
                System.out.println("Invalid input! Please enter an integer value!");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        tree.insert(value);

        System.out.print("Would you like to insert another node? (Yes/No): ");
        insertAgain = scanner.nextLine().trim().toLowerCase();
    } while (insertAgain.equals("yes") || insertAgain.equals("y"));
}

    private static void deleteNode() {
        System.out.print("Enter the value to delete: ");
        int value;
        while (true) {
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch (Exception e) { // User entered a String instead of integer
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        tree.delete(value);
    }

    private static void searchNode() {
        System.out.print("Enter Integer value to search: ");
        int data;
        while (true) {
            try {
                data = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch (Exception e) { // User entered a String instead of integer
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        boolean found = tree.search(data);
        System.out.println("Search result for " + data + ": " + (found ? "Found" : "Not Found")); // Ternary Operator
    }

    private static void printTree() {
        tree.printPreOrder();
    }
}