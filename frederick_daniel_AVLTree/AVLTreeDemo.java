package frederick_daniel_AVLTree;

import java.util.Scanner;

public class AVLTreeDemo {
  private static AVLTree tree = new AVLTree(); // Initiate the AVLTree tree Object
  private static Scanner scanner = new Scanner(System.in); // Initiate a Scanner for user input

  public static void main(String[] args) {

    while (true) { // Loop the menu and ask user for input 
      int menu; // Initiate menu option(int) for use input
      while (true) { // Loop to make sure user puts in correct input
        printMenu(); // Prints the menu
        if (scanner.hasNextInt()) { // Ask user for input and check if input is an integer
          menu = scanner.nextInt(); // Input is an integer
          break; // Jumps out of the while loop
        } else { // User input was not an integer
          System.out.println("Invalid input. Please enter one of the options!");
          scanner.nextLine(); // Consume the invalid input
        }
      }

      switch (menu) { // Switch to see what option user entered
        case 1:
          // User entered "1" and wants to insert nodes into AVLTree
          insertNodeRepeat();
          break;
        case 2:
          // User entered "2" and wants to delete nodes from AVLTree
          deleteNode();
          break;
        case 3:
          // User entered "3" and wants to search for a node in the AVLTree
          searchNode();
          break;
        case 4:
          // User entered "4" and wants to print the AVLTree
          printTree();
          break;
        case 5:
          // User entered "5" and wants to exit the program
          System.out.println("Exiting Program... ");
          System.exit(menu); // Exits the program
          break;
        default:
          // User entered a number less than 1 or greater than 5 which is not allowed
          System.out.println("Invalid input. Please enter one of the options!");
      }
    }
  }

  // Method to print the menu to the user
  private static void printMenu() {
    System.out.println(); // adds Spacing
    System.out.println("AVL Tree Operations");
    System.out.println("1. Insert Node");
    System.out.println("2. Delete Node");
    System.out.println("3. Search Node");
    System.out.println("4. Print Tree");
    System.out.println("5. Exit");
    System.out.print("Choose an option: ");
  }

  // User wants to input a new Node into the AVLTree
  private static void insertNodeRepeat() {
    String insertAgain; // Initiate insertAgain if the user wants to put in another Node
    // Do-While loop to first ask the user to input a value then ask if they want to input more
    do {
      // Ask user to input a value for new Node
      System.out.print("Enter integer value to insert: ");
      int value; // Initiate value for the new Node
      while (true) { // Loop to make sure user puts in correct input
        try { // try-catch to see if the user inputs a String stead of a integer
          value = scanner.nextInt(); // Ask user for a integer
          scanner.nextLine(); // Consume the newline character
          break; // Jumps out of the while loop
        } catch (Exception e) { // User entered a String instead of integer
          System.out.println("Invalid input! Please enter an integer value!");
          scanner.nextLine(); // Consume the invalid input
        }
      }
      // Now that we know the user input is an integer, add a new Node with that value
      tree.insert(value);

      // Ask user if they want to input another Node into the AVLTree
      System.out.print("Would you like to insert another node? (Yes/No): ");
      insertAgain = scanner.nextLine().trim().toLowerCase();
      // If the user input is anything besides "yes" or "y," then leave this part
    } while (insertAgain.equals("yes") || insertAgain.equals("y"));
  }

  // User wants to delete a Node in the AVLTree
  private static void deleteNode() {
    System.out.print("Enter the value to delete: ");
    int value; // Initiate value for the Node they wish to delete 
    while (true) { // Loop to make sure user puts in correct input
      try { // try-catch to see if the user inputs a String stead of a integer
        value = scanner.nextInt(); // Ask user for a integer
        scanner.nextLine(); // Consume the newline character
        break; // Jumps out of the while loop
      } catch (Exception e) { // User entered a String instead of integer
        System.out.println("Invalid input. Please enter an integer value.");
        scanner.nextLine(); // Consume the invalid input
      }
    }
    // Now that we know the user input is an integer, delete the Node with that value and adjust the tree accordingly
    tree.delete(value);
  }

  // User wants to search for a Node in the AVLTree
  private static void searchNode() {
    System.out.print("Enter Integer value to search: ");
    int data; // Initiate value for the Node they wish to search for
    while (true) { // Loop to make sure user puts in correct input
      try { // try-catch to see if the user inputs a String stead of a integer
        data = scanner.nextInt(); // Ask user for a integer
        scanner.nextLine(); // Consume the newline character
        break; // Jumps out of the while loop
      } catch (Exception e) { // User entered a String instead of integer
        System.out.println("Invalid input. Please enter an integer value.");
        scanner.nextLine(); // Consume the invalid input
      }
    }
    // Now that we know the user input is an integer, search for the Node with that value
    boolean found = tree.search(data);

    // Output the result of the search
    System.out.println("Search result for " + data + ": " + (found ? "Found" : "Not Found")); // Ternary Operator used to print the result
  }

    private static void printTree() {
    // There is no user input in this method so we only need to call the printPreOrder() method
    tree.printPreOrder();
  }
}
